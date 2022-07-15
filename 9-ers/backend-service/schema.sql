select * from users;
select * from roles;
select * from user_roles;
select * from reimbursements;

insert into roles(id,name) values (1,'EMPLOYEE');
insert into roles(id,name) values (2,'MANAGER');

insert into users(id,emp_id,name,password) values (1,1212,'Tom','123');
insert into users(id,emp_id,name,password) values (2,1313,'Jerry','123');
insert into users(id,emp_id,name,password) values (3,1414,'Nag','123');

insert into user_roles(user_id,role_id) values (1,1);
insert into user_roles(user_id,role_id) values (2,1);
insert into user_roles(user_id,role_id) values (3,1);
insert into user_roles(user_id,role_id) values (3,2);
