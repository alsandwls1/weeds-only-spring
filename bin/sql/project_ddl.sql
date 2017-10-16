select * from project;

drop table project;

create table project(
	domian  VARCHAR(50) NOT NULL PRIMARY KEY,
	p_name  VARCHAR(30) NOT NULL
);

insert into project(domian,p_name) values('aaaa', 'a');
insert into project(domian,p_name) values('bbbb', 'b');