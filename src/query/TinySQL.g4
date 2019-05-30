grammar TinySQL;

parse
: (sql_stmt_list | error)* EOF
;

error
:UNEXPECTED_CHAR
    {
      throw new RuntimeException("UNEXPECTED_CHAR=" + $UNEXPECTED_CHAR.text);
    }
;

sql_stmt_list
 : ';'* sql_stmt ( ';'+ sql_stmt )* ';'*
 ;


sql_stmt
: create_database_stmt
| show_databases_stmt
| show_database_tables_stmt
| create_table_stmt
| insert_table_stmt
| select_table_stmt
| update_table_stmt
| delete_table_stmt
| drop_database_stmt
| drop_table_stmt
| use_database_stmt

;

show_databases_stmt
:K_SHOW K_DATABASES
;

show_database_tables_stmt
:K_SHOW K_DATABASE database_name
;

create_database_stmt
: K_CREATE K_DATABASE database_name
;
create_table_stmt
 : K_CREATE K_TABLE
   ( database_name '.' )? table_name
   ( '(' column_def ( ',' column_def )* ( ',' table_constraint )* ')'
   )
 ;

column_def
 : column_name type_name column_constraint*
 ;

table_constraint
: ( K_PRIMARY K_KEY  ) '(' indexed_column ( ',' indexed_column )* ')'
;

indexed_column
 : column_name ( K_ASC | K_DESC )?
 ;

insert_table_stmt
: K_INSERT K_INTO ( database_name '.' )? table_name ( '(' column_name ( ',' column_name )* ')' )?
              ( K_VALUES '(' expr ( ',' expr )* ')' ( ',' '(' expr ( ',' expr )* ')' )* )
;

expr
: literal_value
 | ( ( database_name '.' )? table_name '.' )? column_name
 | unary_operator expr
// | expr '||' expr
// | expr ( '*' | '/' | '%' ) expr
 | expr ( '+' | '-' ) expr
// | expr ( '<<' | '>>' | '&' | '|' ) expr
 | expr ( '<' | '<=' | '>' | '>=' ) expr
 | expr ( '=' | '==' | '!=' | '<>') expr
// | expr K_AND expr
// | expr K_OR expr
 | '(' expr ')'
// | expr ( K_ISNULL | K_NOTNULL | K_NOT K_NULL )
// | expr K_IS K_NOT? expr
// | expr K_NOT? K_BETWEEN expr K_AND expr
 ;


unary_operator
 : '-'
 | '+'
 | '~'
 | K_NOT
 ;

literal_value
: NUMERIC_LITERAL
 | STRING_LITERAL
 | K_NULL
;

STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;


select_table_stmt
: K_SELECT ( K_DISTINCT | K_ALL )? result_column ( ',' result_column )*
     ( K_FROM ( table_name ( ',' table_name )* | join_clause ) )?
     ( K_WHERE expr )?
//     ( K_GROUP K_BY expr ( ',' expr )* ( K_HAVING expr )? )?
//   | K_VALUES '(' expr ( ',' expr )* ')' ( ',' '(' expr ( ',' expr )* ')' )*
 ;

result_column
 :
 | '*'
 | table_name '.' '*'
 | expr
 ;

join_clause
:table_name ( join_operator table_name join_constraint )*
;
join_constraint
 : ( K_ON expr)?
 //  | K_USING '(' column_name ( ',' column_name )* ')' )?
 ;

join_operator
 : ','
 | K_NATURAL? ( K_LEFT K_OUTER? | K_INNER )? K_JOIN
 ;


update_table_stmt
: K_UPDATE table_name K_SET column_name '=' expr ( ',' column_name '=' expr )* ( K_WHERE expr )?
;

delete_table_stmt
: K_DELETE K_FROM table_name K_WHERE expr
;



drop_database_stmt
: K_DROP K_DATABASE database_name
;

drop_table_stmt
: K_DROP K_TABLE table_name
;

use_database_stmt
: K_USE database_name
;




type_name
 : name ( '(' signed_number ')' )?
 ;
signed_number
 : ( '+' | '-' )? NUMERIC_LITERAL
 ;

column_constraint
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
: any_name
;

database_name
 : any_name
 ;

table_name
 : any_name
 ;

column_name
 : any_name
 ;

any_name
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
UNEXPECTED_CHAR
 : .
 ;

IDENTIFIER
 :
 [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
 ;