create table noPrimary(
    id int
);
insert into noPrimary values(-7);
insert into noPrimary values(2);
select * from noPrimary;
delete from noPrimary where id < 1;
select * from noPrimary;


create table hasPrimary(
    id int primary key
);
insert into hasPrimary values(-7);
insert into hasPrimary values(2);
select * from hasPrimary;
delete from hasPrimary where id < 1;
select * from hasPrimary;


create table multiPrimary(
    id int primary key,
    a double primary key,
    b string(30) primary key,
    c long primary key,
    d float primary key
);
insert into multiPrimary values(-5, 3.2, 'jiowejgwwe2', -90, -4.3);
insert into multiPrimary values(-5, 3.2, 'jiowejgwwe3', 0, -4.3);
select * from multiPrimary;
delete from multiPrimary where id + c +a > d;
select * from multiPrimary;