select * from member;

drop table member;

create table member(
	email  VARCHAR(50) NOT NULL PRIMARY KEY,
	password  VARCHAR(30) NOT NULL,
	name  VARCHAR(30) NOT NULL,
	profile_img VARCHAR(100) 
);

insert into member(email,password,name,profile_img) values('a@naver.com', 'a', 'a', '/assets/image/character_01.png');
insert into member(email,password,name,profile_img) values('b@naver.com', 'b', 'b', '/assets/image/character_01.png');
insert into member(email,password,name,profile_img) values('c@naver.com', 'c', 'c', '/assets/image/character_01.png');
insert into member (email, password, name) values ('d@naver.com', 'd', 'd'); 