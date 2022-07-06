Hibernate: create table todos (id int4 not null, completed boolean not null, title varchar(255), type varchar(255), user_id int4, primary key (id))
Hibernate: create table users (id int4 not null, name varchar(255), password varchar(255), username varchar(255), primary key (id))
Hibernate: alter table if exists todos add constraint FK9605g76a1dggbvs18f2r80gvu foreign key (user_id) references users