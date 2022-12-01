create database finalProject;
use finalProject;


CREATE TABLE accounts(
    userName varchar(50) not null,
    userPassword varchar(50) not null,
    userRole varchar(50) not null,
    primary key(userName)
);

CREATE TABLE todo(
	id int not null auto_increment, -- toujours mettre null en id lors de la création d'un todo
    todoDesc varchar(100) not null,
    primary key(id)
);

-- affichage list todo :
select todoDesc from todo;

-- update table to do : add, modify, delete 
insert into todo values(null, "finir exo2");
update todo set todoDesc='' where id='';
delete from todo where id='';

-- update table accounts : add, delete, modify password 
insert into accounts values("DianeKrychowski", "password", "student");
update accounts set password='' where userName='';
delete from accounts where userName='';




