create table system (
	id integer primary key,
	name varchar2(200) not null,
	code varchar2(10) not null
);

create sequence system_seq start with 1;