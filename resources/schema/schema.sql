create database a;
use a;
create table table1(
    id int,
    name string(10)
);
create table table2(
    id int,
    name string(10)
);
use test;
create table table1(
    id int,
    name string(10)
);
create table table2(
    id int,
    name string(10)
);
use a;
drop table table1;
show database a;
use test;
drop database a;
