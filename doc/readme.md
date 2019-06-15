# 说明文档
## 设计及实现思路

### 索引及存储管理


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
