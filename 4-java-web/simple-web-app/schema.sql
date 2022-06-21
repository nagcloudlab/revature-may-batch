create table users(
                      username varchar(255) primary key,
                      password varchar(255),
                      name varchar(255)
);
create table roles(create table users(
    username varchar(255) primary key,
    password varchar(255),
    name varchar(255)
    );
create table roles(
                      id int primary key,
                      role varchar(255)
);
create table user_roles(
                           role_id int references roles(id),
                           user_id varchar(255) references users(username)
);
insert into users(username,password,name) values('tom','tom123','TOM');
insert into roles (id,role) values(1,'USER');
insert into roles (id,role) values(2,'MANAGER');
insert into roles (id,role) values(3,'ADMIN');

insert into user_roles(role_id,user_id) values(1,'tom')
insert into user_roles(role_id,user_id) values(2,'tom')
insert into user_roles(role_id,user_id) values(3,'tom')

    id int primary key,
                      role varchar(255)
);
create table user_roles(
                           role_id int references roles(id),
                           user_id varchar(255) references users(username)
);
insert into users(username,password,name) values('tom','tom123','TOM');
insert into roles (id,role) values(1,'USER');
insert into roles (id,role) values(2,'MANAGER');
insert into roles (id,role) values(3,'ADMIN');

insert into user_roles(role_id,user_id) values(1,'tom')
insert into user_roles(role_id,user_id) values(2,'tom')
insert into user_roles(role_id,user_id) values(3,'tom')
