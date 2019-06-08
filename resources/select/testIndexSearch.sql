create table employee(
    id int,
    primary key(id)
);

insert into employee values(-4);
insert into employee values(-3);
insert into employee values(-5);
insert into employee values(1);
insert into employee values(2);
insert into employee values(3);
insert into employee values(4);
insert into employee values(5);
insert into employee values(6);
insert into employee values(7);
insert into employee values(8);
insert into employee values(9);
insert into employee values(10);
insert into employee values(11);
insert into employee values(12);
insert into employee values(13);
insert into employee values(0);
insert into employee values(-1);
-- insert into employee values(-2);

select * from employee where id < 8;