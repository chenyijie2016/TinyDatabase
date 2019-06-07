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


select * from employee;
select dept_name, salary, name, id from employee where id=12121;
select dept_name, salary, name, id from employee;
select dept_name, name, id, salary from employee where salary>=80000;
select * from employee where dept_name=='Comp.Sci.';
select * from employee where id>45565;
select * from employee where id>=45565;
select * from employee where id<45565;
select * from employee where id<=45565;
select * from employee where id>45565;
select * from employee where id=45565;
select * from employee where id!=45565;
select * from employee where salary>80000;
select * from employee where salary>=80000;
select * from employee where salary<80000;
select * from employee where salary<=80000;
select * from employee where salary>80000;
select * from employee where salary=80000;
select * from employee where salary<>80000;


create table employee2(
    id int,
    name string(20),
    dept_name string(20),
    salary int,
    primary key(id)
);
insert into employee2 values (10101, 'Srinivasan','Comp. Sci.',65000 );
insert into employee2 values (12121,'Wu','Finance',90000);
insert into employee2 values (15151, 'Mozart', 'Music', 40000);
insert into employee2 values (40000, 'Einstein', 'Physics', 95000);
insert into employee2 values (32343, 'El Said', 'History', 60000);
insert into employee2 values (33456, 'Gold', 'Physics', 87000);
insert into employee2 values (45565, 'Katz', 'Comp.Sci.', 75000);
insert into employee2 values (58583, 'Califieri', 'History', 62000);
insert into employee2 values (76543, 'Singh', 'Finance', 80000);
insert into employee2 values (76766, 'Crick', 'Biology', 72000);
insert into employee2 values (98345, 'Kim', 'Elec.Eng.', 80000);
insert into employee2 values (83821, 'Brandt', 'Comp.Sci.', 92000);

create table employee3(
    id int,
    name string(20),
    dept_name string(20),
    salary int,
    primary key(id)
);
insert into employee3 values (10101, 'Srinivasan','Comp. Sci.',65000 );
insert into employee3 values (12121,'Wu','Finance',90000);
insert into employee3 values (15151, 'Mozart', 'Music', 40000);
insert into employee3 values (40000, 'Einstein', 'Physics', 95000);
insert into employee3 values (32343, 'El Said', 'History', 60000);
insert into employee3 values (33456, 'Gold', 'Physics', 87000);
insert into employee3 values (45565, 'Katz', 'Comp.Sci.', 75000);
insert into employee3 values (58583, 'Califieri', 'History', 62000);
insert into employee3 values (76543, 'Singh', 'Finance', 80000);
insert into employee3 values (76766, 'Crick', 'Biology', 72000);
insert into employee3 values (98345, 'Kim', 'Elec.Eng.', 80000);
insert into employee3 values (83821, 'Brandt', 'Comp.Sci.', 92000);

select * from employee join employee2 on employee.dept_name = employee2.dept_name;
select * from employee join employee2 on employee.dept_name = employee2.dept_name where employee.salary > 80000;
select employee.name, employee2.name from employee join employee2 on employee2.id = employee.salary;
select distinct employee.name from employee join employee2 on employee.dept_name = employee2.dept_name where employee.salary > 80000;
select * from employee, employee2 join employee3 on employee3.dept_name = employee2.dept_name;