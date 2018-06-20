create table content_type (
	id integer primary key,
	name varchar2(200) not null
);

create sequence content_type_seq start with 1;