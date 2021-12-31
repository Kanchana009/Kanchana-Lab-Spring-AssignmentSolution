create database collegefest;
use collegefest;

create table students(
id int(11) not null auto_increment,
name varchar(45) not null,
department varchar(45) not null,
country varchar(45) not null,
primary key(id)
);