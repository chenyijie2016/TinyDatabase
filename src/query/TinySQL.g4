grammar TinySQL;

entry
: (sql_stmt_list)* EOF
;

sql_stmt_list
: ';'* sql_stmt ( ';' + sql_stmt )* ';'*
;

sql_stmt
: create_database_stmt
| create_table_stmt
| drop_database_stmt
| drop_table_stmt
| use_database_stmt
;

create_database_stmt
: K_CREATE K_DATABASE database_name
;

create_table_stmt
: K_CREATE K_TABLE table_name
( '(' column_def ( ',' column_def )* (',' table_constraint)* ')' )?
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

column_def
 : column_name type_name? column_constraint*
 ;


table_constraint
: ( K_PRIMARY K_KEY  ) '(' column_name ( ',' column_name )* ')'
;


type_name
 : name+ ( '(' signed_number ')' )?
 ;
signed_number
 : ( '+' | '-' )? NUMERIC_LITERAL
 ;

column_constraint
: K_PRIMARY K_KEY
| K_NOT K_NULL
;

IDENTIFIER
 : '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
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

table_or_index_name
 : any_name
 ;


column_name
 : any_name
 ;

any_name
 : IDENTIFIER
 | keyword
 | '(' any_name ')'
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
;
K_CREATE: C R E A T E;
K_DATABASE: D A T A B A S E;
K_TABLE: T A B L E;
K_DROP: D R O P;
K_SELECT: S E L E C T;
K_UPDATE: U P D A T E;
K_DELETE: D E L E T E;
K_INSERT: I N S E R T;
K_PRIMARY: P R I M A R Y;
K_KEY: K E Y;
K_NOT: N O T;
K_NULL: N U L L;
K_WHERE: W H E R E;
K_INTO: I N T O;
K_FROM: F R O M;
K_USE: U S E;

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