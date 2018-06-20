create table content_liv (
	id integer primary key,
	content_liv clob not null,
	date_create timestamp default sysdate not null,
	date_modify timestamp,
	active char,
	system_id integer not null,
	content_type_id integer not null,
	constraint fk_system FOREIGN KEY (system_id) REFERENCES system (id),
	constraint fk_content_type FOREIGN KEY (content_type_id) REFERENCES content_type (id)
);

create sequence content_seq start with 1;