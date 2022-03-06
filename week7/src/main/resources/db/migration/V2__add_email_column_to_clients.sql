alter table clients add email varchar(255) not null;
alter table clients add constraint email unique (email);