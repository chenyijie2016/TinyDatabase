create table noPrimary(
    id int
);
insert into noPrimary values(-3);
insert into noPrimary values(2);
select * from noPrimary;
delete from noPrimary where id < 1;
select * from noPrimary;