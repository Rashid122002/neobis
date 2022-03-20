create table roles (id bigint not null auto_increment, name varchar(255), primary key (id));
create table users (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id));
create table users_roles (user_id bigint not null, roles_id bigint not null, primary key (user_id, roles_id));
alter table users_roles add constraint roles_id_fk foreign key (roles_id) references roles (id);
alter table users_roles add constraint user_id_fk foreign key (user_id) references users (id);