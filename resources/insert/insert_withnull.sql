create table employee(
    id int,
    foo float,
    bar double,
    qux long,
    name string(20),
    dept_name string(20),
    salary int,
    primary key(id)
);

insert into employee values (213,null,null,null,null,null,null);
select * from employee;