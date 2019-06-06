create table employee(
    id int,
    name string(20),
    dept_name string(20),
    salary int,
    primary key(id)
);
insert into employee values (10101, 'Srinivasan','Comp. Sci.',65000 );
insert into employee values (12121,'Wu','Finance',90000);
insert into employee values (15151, 'Mozart', 'Music', 40000);
insert into employee values (22222, 'Einstein', 'Physics', 95000);
insert into employee values (32343, 'El Said', 'History', 60000);
insert into employee values (33456, 'Gold', 'Physics', 87000);
insert into employee values (45565, 'Katz', 'Comp.Sci.', 75000);
insert into employee values (58583, 'Califieri', 'History', 62000);
insert into employee values (76543, 'Singh', 'Finance', 80000);
insert into employee values (76766, 'Crick', 'Biology', 72000);
insert into employee values (98345, 'Kim', 'Elec.Eng.', 80000);
insert into employee values (83821, 'Brandt', 'Comp.Sci.', 92000);

update employee set salary=0 where salary>80000;
update employee set name='TEMPBIGGERTHAN' where id<32343;

select * from employee;