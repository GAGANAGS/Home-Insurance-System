create database HomeInsDB; 
use HomeInsDB;

create table customer(
firstName varchar(20),
lastName varchar(20),
password varchar(20),
email varchar(30) primary key,
gender varchar(10),
dob date,
city varchar(20),
accnumber int unique auto_increment,
amount int
);

create table quote(
qid int primary key auto_increment,
sqft int,
years int,
costpersqft int,
price int,
location varchar(30)
);


create table policy(
pId int primary key auto_increment,
qid int,
orderDate date,
email varchar(10),
price int, 
constraint c_o_fk foreign key(email) references customer(email)
);