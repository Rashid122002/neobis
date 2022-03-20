alter table orders add constraint user_id_fk1 foreign key (user_id) references users (id);
drop table clients;