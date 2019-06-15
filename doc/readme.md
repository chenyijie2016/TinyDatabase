# 说明文档
## 设计及实现思路

### 索引及存储管理

索引文件使用B+树(`src/index/BPlusTree`)的形式来组织，在B+树的叶子节点中不仅有指向下一个叶子节点的指针(`next`)，也额外添加了指向上一个叶子节点的指针(`prev`),以便对于索引采用逆向的方式进行遍历搜索。

多类型数据通过统一的接口进行访问(`src/data/typedData`)，同时可以通过工厂模式(`src/data/typedDataFactor`)进行快捷的生成。

文件组织采用基于定长记录的文件存储形式，文件头存储有关信息，采用**空闲列表**(free list)的方式来提高空间利用率，即在文件头存储最后被删除的记录的位置，在被删除的记录位置存储上一个被删除的记录的位置。
这些位置会在插入记录或者删除记录时进行动态更新。


### 元数据管理

元数据通过多级文件和不同层级文件名进行分层管理，核心元数据文件(`schema`)为最高级，存储数据库信息(数据库名)，
数据库级元数据文件(`[数据库名].meta`)存储该数据库中所有表的元数据(表名，列名，列类型，约束)。

> 与元数据有关的类均在`src/schema`下

数据库启动时，会首先寻找当前目录下的`schema`文件，如果未找到，则会创建一个默认的初始数据库,名称为`TEST`，并创建相关的元数据文件。
如果找到，则会从该文件进行读取，并依次创建`DataBase`类的实例和属于其的`Table`的实例。

元数据的访问通过`src/schema/Schema`这个类进行实现，该类被实现为单例模式，提供了创建/查找/删除数据库的接口。
在数据库(`src/database/DataBase`)的层级上，则提供了创建/查找/删除表的功能。

类`src/schema/SchemaManager`与服务端的实现有关，其每一个实例对应每一个客户端连接，实现了多客户端同时访问时指定不同的数据库的功能。


### SQL解析

使用ANTLR进行解析，分别对不同的语句规则进行匹配，解析过程中进行基本的文法检查，而在具体的运行过程中可能会抛出更多类型或者文法细节方面的异常。

SQL解析过程中，得到的解析结果以Statement类的格式进行存储，涉及的文件均在`src\query\statement`文件夹下：

- Statement作为基类，实现了记录SQL命令、正确性验证与错误存储等功能，具体的执行等方法交由对应的子类实现；
- SchemaStatement：涉及到数据库操作的相关语句处理，如创建、使用、删除数据库，显示数据库和数据库表的相关信息；
- CreateTableStatement、DeleteTableStatement、InsertTableStatement、SelectTableStatement、UpdateTableStatement：分别负责执行数据库表的对应操作。

SQL解析过程中，涉及到的表达式使用栈的方式进行解析，涉及的文件均在`src\query\expression`文件夹下，具体的类包括：

- BaseData：常数/某列数据；
- Expression：表达式的基类；
- ValueExpression：非布尔值的表达式，即数据（ValueExpression或BaseData）之间的数学运算，或者BaseData本身；
- CompareExpression：布尔值，即条件，其中会包含ValueExpression之间的大小比较或者CompareExpression之间的与、或关系。

### SQL执行

SQL执行过程中需要的参数已经全部在SQL解析的过程中存入了Statement对应的属性中，解析过程使用统一的SchemaManager进行管理，执行的结果会放入Result类的实例中返回。

Schema管理：

- 使用SchemaManager类（见`src\schema`文件夹）进行，其中记录了当前的数据库信息，可以实现对数据库的操作。

数据遍历与选取的实现：

- where条件的处理：
  - 类型检查与预计算：对于where条件，会深度优先遍历其下层结构，对于所有可以计算出来的值进行处理，计算出结果并且直接保存在节点中以供后续使用。对于列数据，会检查其可访问性并且在check的过程中存储对应的表和列的引用。
  - 索引与验证：首先尝试利用索引树来缩小查询范围，如果失败就会将where条件保留，并且直接全部遍历并每次进行检查。在Expression中实现了根据传入的row进行计算的函数，可以直接通过遍历过程中访问到的数据判断条件是否符合。

多表join操作的实现：

- join操作时，会对on条件中的条件按照对应的表和列进行分类，统计得到有哪些列需要重命名，并且维护一个每个表需要满足的约束的map。
- 基于回溯法，使用多iterator进行多张表的遍历。每次iterator生成时都会首先考虑join条件中的限制，选择其中的约束以达到减少索引范围的目的。

结果存储：

- 使用Result类（见`src\query`文件夹）进行结果的存储，其继承TableBase得到了存储select结果与提示信息的能力，并且实现了倒序插入、distinct插入的方式。

错误处理：

- 使用自定义的错误类型SQLExecuteException（见`src\exception`）实现了执行过程中报错的统一化、规范化，便于后续catch与处理。


### 客户端/服务端通信

客户端和服务端通过统一的协议来进行数据包的解析，详见`src/server/Protocol`。

当返回的表数据太大时，客户端接收到的数据包可能不是完整的，协议中对于包尾做出了规定，以便客户端对于多个数据包进行整合处理。


## 运行与测试

可以直接运行所打包的jar文件

服务端:（端口不指定时默认3306）

```
usage: java -jar TinyDatabaseServer.jar
 -p,--port <arg>   port
```

客户端:（端口不指定时默认3306,主机名不指定时默认为localhost）
```
usage: java -jar TinyDatabaseClient.jar
 -h,--host <arg>   hostname
 -p,--port <arg>   port
```

运行客户端后会显示GUI界面，此时还必须点击file菜单下的connect选项主动连接服务端

file菜单下有import选项，可以选择文件进行导入

导入后可以点击execute SQL按钮进行语句的执行，界面最下方的状态栏会显示一次发送的所有语句的总执行时间。

