create table student (
    id     int not null primary key,
    name   string(32) not null,
    height double not null,
    weight float,
    score  long
);

insert into student values(3, 'abc', 3.2, 5.21, 8000);
insert into student(id, height, name) values(8, 5.2, 'bcd');
insert into student values(7, 'cde', 5, 3.2, 7000);

select * from student where score isnull;  -- bcd
select * from student where weight not null;  -- abc, cde
select name, id from student where score > 7000 or height > 4;  -- abc, cde, bcd
select id, name from student where height > weight;  -- cde


create table tutor (
    id      int not null primary key,
    name    string(20) not null,
    salary  double,
    dept    string(40)
);

create table dept (
    name    string(40) primary key not null,
    building    int,
    alias   string(30),
    year    long not null
);

create table tutorRelation (
    tutor_id    int not null,
    student_id  int not null,
    id          int primary key
);

insert into tutor values(1, 'tutor1', 70, 'Software');
insert into tutor values(2, 'tutor2', 7000, 'EE');
insert into tutor values(4, 'BOb', 90000.3, 'EE');
insert into tutor(id, name, dept) values(3, 'Alice', 'CS');

insert into dept(name, building, year, alias) values('Software', 1, 2001, 'SS');
insert into dept(name, year, building) values('EE', 1998, 5);
insert into dept(name, year, alias) values('CS', 1990, 'NineJin');

insert into tutorRelation values(1, 3, 1);
insert into tutorRelation values(1, 8, 2);
insert into tutorRelation values(2, 7, 3);
insert into tutorRelation values(3, 7, 4);
insert into tutorRelation values(1, 7, 5);
insert into tutorRelation values(4, 7, 6);

select * from student join dept join tutor join tutorRelation on tutorRelation.tutor_id = tutor.id
    and tutorRelation.student_id=student.id and dept.name=tutor.dept where student.score > 7600.3 or student.height > student.weight + 1;

select student.id, student.name, tutor.id, tutor.name, dept.name, dept.alias from student join dept join tutor join tutorRelation on tutorRelation.tutor_id = tutor.id
    and tutorRelation.student_id=student.id and dept.name=tutor.dept where tutor.salary notnull;

select student.id, student.name, tutor.id, tutor.name, dept.name, dept.alias from student join dept join tutor join tutorRelation on tutorRelation.tutor_id = tutor.id
    and tutorRelation.student_id=student.id and dept.name=tutor.dept;

update tutor set salary = 9999 where salary isnull;

select * from tutor;