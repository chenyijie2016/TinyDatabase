grammar TinySQL;

parse
: (sqlStatementList | error)* EOF
;

error
:UNEXPECTED_CHAR
    {
      throw new RuntimeException("UNEXPECTED_CHAR=" + $UNEXPECTED_CHAR.text);
    }
;

sqlStatementList
 : ';'* sqlStatement ( ';'+ sqlStatement )* ';'*
 ;


sqlStatement
: createDatabaseStmt
| showDatabasesStmt
| showDatabaseTablesStmt
| createTableStmt
| insertTableStmt
| selectTableStmt
| updateTableStmt
| deleteTableStmt
| dropDatabaseStmt
| dropTableStmt
| useDatabaseStmt

;

showDatabasesStmt
:K_SHOW K_DATABASES
;

showDatabaseTablesStmt
:K_SHOW K_DATABASE databaseName
;

createDatabaseStmt
: K_CREATE K_DATABASE databaseName
;
createTableStmt
 : K_CREATE K_TABLE
   ( databaseName '.' )? tableName
   ( '(' columnDefinition ( ',' columnDefinition )* ( ',' tableConstraint )? ')'
   )
 ;

columnDefinition
 : columnName typeName columnConstraint*
 ;

tableConstraint
: ( K_PRIMARY K_KEY  ) '(' indexedColumn ( ',' indexedColumn )* ')'
;

indexedColumn
 : columnName ( K_ASC | K_DESC )?
 ;

insertTableStmt
: K_INSERT K_INTO tableName ( '(' columnName ( ',' columnName )* ')' )?
              ( K_VALUES '(' expression ( ',' expression )* ')' ( ',' '(' expression ( ',' expression )* ')' )* )
;

expression
: literalValue                                       # valueExpression
 | ( tableName '.' )? columnName                     # tableColumnExpression
 | unaryOperator expression                          # unaryExpression
// | expr '||' expr
// | expression ( '*' | '/' | '%' ) expression
 | expression ( '+' | '-' ) expression               # addSubExpression
// | expression ( '<<' | '>>' | '&' | '|' ) expression
 | '(' expression ')'                                # parenthesisExpression
 ;

conditionExpression
: expression ( '<' | '<=' | '>' | '>=' ) expression  # lessGreaterExpression
 | expression ( '=' | '==' | '!=' | '<>') expression # equalExpression
 | '(' conditionExpression ')'                       # parenthesisConditionExpression
// | conditionExpression K_AND conditionExpression
// | conditionExpression K_OR conditionExpression
// | expression ( K_ISNULL | K_NOTNULL | K_NOT K_NULL )
// | expression K_IS K_NOT? expression
// | expression K_NOT? K_BETWEEN expression K_AND expression
;


unaryOperator
 : '-'
 | '+'
 | '~'
 | K_NOT
 ;

literalValue
: NUMERIC_LITERAL
 | STRING_LITERAL
 | K_NULL
;

STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;


selectTableStmt
: K_SELECT ( K_DISTINCT | K_ALL )? resultColumn ( ',' resultColumn )*
     ( K_FROM ( tableName ( ',' tableName )* | joinClause ) )?
     ( K_WHERE conditionExpression )?
//     ( K_GROUP K_BY expr ( ',' expr )* ( K_HAVING expr )? )?
//   | K_VALUES '(' expr ( ',' expr )* ')' ( ',' '(' expr ( ',' expr )* ')' )*
 ;

resultColumn
 :
 | '*'
 | tableName '.' '*'
 | expression
 ;

joinClause
:tableName ( joinOperator tableName joinConstraint )*
;
joinConstraint
 : ( K_ON conditionExpression)?
 //  | K_USING '(' column_name ( ',' column_name )* ')' )?
 ;

joinOperator
 : ','
 | K_NATURAL? ( K_LEFT K_OUTER? | K_INNER )? K_JOIN
 ;


updateTableStmt
: K_UPDATE tableName K_SET columnName '=' expression ( ',' columnName '=' expression )* ( K_WHERE conditionExpression )?
;

deleteTableStmt
: K_DELETE K_FROM tableName K_WHERE conditionExpression
;



dropDatabaseStmt
: K_DROP K_DATABASE databaseName
;

dropTableStmt
: K_DROP K_TABLE tableName
;

useDatabaseStmt
: K_USE databaseName
;




typeName
 : name ( '(' signedNumber ')' )?
 ;
signedNumber
 : ( '+' | '-' )? NUMERIC_LITERAL
 ;

columnConstraint
: K_PRIMARY K_KEY (K_ASC | K_DESC)?
| K_NOT K_NULL
;

SINGLE_LINE_COMMENT
 : '--' ~[\r\n]* -> channel(HIDDEN)
 ;

MULTILINE_COMMENT
 : '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN)
 ;

SPACES
 : [ \u000B\t\r\n] -> channel(HIDDEN)
 ;

NUMERIC_LITERAL
 : DIGIT+ ( '.' DIGIT* )?
 | '.' DIGIT*
 ;

name
: anyName
;

databaseName
 : anyName
 ;

tableName
 : anyName
 ;

columnName
 : anyName
 ;

anyName
 : IDENTIFIER
 | keyword
 ;


keyword
: K_CREATE
| K_DATABASE
| K_TABLE
| K_DROP
| K_SELECT
| K_UPDATE
| K_DELETE
| K_INSERT
| K_PRIMARY
| K_KEY
| K_NOT
| K_NULL
| K_WHERE
| K_INTO
| K_FROM
| K_USE
| K_ASC
| K_DESC
| K_VALUES
| K_DATABASES
| K_SHOW
| K_LEFT
| K_INNER
| K_SET
;

K_CREATE : C R E A T E;
K_DATABASE : D A T A B A S E;
K_TABLE : T A B L E;
K_DROP : D R O P;
K_SELECT : S E L E C T;
K_UPDATE : U P D A T E;
K_DELETE : D E L E T E;
K_INSERT : I N S E R T;
K_PRIMARY : P R I M A R Y;
K_KEY : K E Y;
K_NOT : N O T;
K_NULL : N U L L;
K_WHERE : W H E R E;
K_INTO : I N T O;
K_FROM : F R O M;
K_USE : U S E;
K_ASC : A S C;
K_DESC : D E S C;
K_VALUES: V A L U E S;
K_DATABASES: D A T A B A S E S;
K_SHOW: S H O W;
K_ON: O N;
K_JOIN: J O I N;
K_NATURAL: N A T U R A L;
K_DISTINCT: D I S T I N C T;
K_ALL: A L L;
K_OUTER: O U T E R;
K_LEFT: L E F T;
K_INNER: I N N E R;
K_SET: S E T;

IDENTIFIER
 :
 [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
 ;

UNEXPECTED_CHAR
 : .
 ;

fragment DIGIT : [0-9];
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];
