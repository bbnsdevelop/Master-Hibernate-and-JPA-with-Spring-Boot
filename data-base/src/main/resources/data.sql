/*create table person (
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
*/
INSERT INTO person (id, name, location, birth_date) VALUES (1001, 'Bruno', 'Sao Paulo', sysdate());
INSERT INTO person (id, name, location, birth_date) VALUES (1002, 'James', 'New York', sysdate());
INSERT INTO person (id, name, location, birth_date) VALUES (1003, 'Pieter', 'Amsterdam', sysdate());
INSERT INTO person (id, name, location, birth_date) VALUES (1004, 'João', 'Rio', sysdate());