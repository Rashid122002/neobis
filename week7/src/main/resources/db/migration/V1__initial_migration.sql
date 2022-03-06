/*
alter table cars drop foreign key price_id_fk
alter table delivery_orders drop foreign key provider_id_fk
alter table delivery_orders drop foreign key purchase_id_fk
alter table delivery_orders drop foreign key staff_id_fk
alter table operations drop foreign key car_id_fk1
alter table operations drop foreign key delivery_order_id_fk
alter table orders drop foreign key car_id_fk2
alter table orders drop foreign key client_id_fk
alter table orders drop foreign key sale_id_fk
drop table if exists cars;
drop table if exists clients;
drop table if exists delivery_orders;
drop table if exists operations;
drop table if exists orders;
drop table if exists prices;
drop table if exists providers;
drop table if exists purchase_descriptions;
drop table if exists sale_descriptions;
drop table if exists staffs;
*/
create table cars (car_id bigint not null auto_increment, car_brand varchar(255) not null, car_color varchar(255) not null, engine_capacity varchar(255) not null, notes varchar(255), serial_number varchar(255) not null, year_of_manufacture date not null, price_id integer, primary key (car_id));
create table clients (client_id bigint not null auto_increment, first_name varchar(255) not null, last_name varchar(255) not null, notes varchar(255), phone_number varchar(255) not null, primary key (client_id));
create table delivery_orders (delivery_order_id bigint not null auto_increment, execution_date date not null, order_description varchar(255), placement_date date not null, provider_id bigint, purchase_id integer, staff_id bigint, primary key (delivery_order_id));
create table operations (operation_id bigint not null auto_increment, cost_up_to double precision not null, factory_price double precision not null, operation_date date not null, operation_description varchar(255) not null, total_amount double precision, car_id bigint, delivery_order_id bigint, primary key (operation_id));
create table orders (order_id bigint not null auto_increment, address varchar(255) not null, document_number varchar(255) not null, document_type varchar(255) not null, order_number varchar(255) not null, placement_date date not null, car_id bigint, client_id bigint, sale_id integer, primary key (order_id));
create table prices (price_id integer not null auto_increment, sale_price double precision not null, primary key (price_id));
create table providers (provider_id bigint not null auto_increment, address varchar(255) not null, city varchar(255) not null, company_name varchar(255) not null, company_official_name varchar(255) not null, fax varchar(255) not null, payment_term varchar(255) not null, phone_number varchar(255) not null, position varchar(255) not null, primary key (provider_id));
create table purchase_descriptions (purchase_id integer not null auto_increment, description varchar(255) not null, primary key (purchase_id));
create table sale_descriptions (sale_id integer not null auto_increment, description varchar(255) not null, primary key (sale_id));
create table staffs (staff_id bigint not null auto_increment, first_name varchar(255) not null, last_name varchar(255) not null, phone_number varchar(255) not null, position varchar(255) not null, primary key (staff_id));
alter table clients add constraint phone_number unique (phone_number);
alter table orders add constraint order_number unique (order_number);
alter table orders add constraint document_number unique (document_number);
alter table providers add constraint phone_number unique (phone_number);
alter table staffs add constraint phone_number unique (phone_number);
alter table cars add constraint price_id_fk foreign key (price_id) references prices (price_id);
alter table delivery_orders add constraint provider_id_fk foreign key (provider_id) references providers (provider_id);
alter table delivery_orders add constraint purchase_id_fk foreign key (purchase_id) references purchase_descriptions (purchase_id);
alter table delivery_orders add constraint staff_id_fk foreign key (staff_id) references staffs (staff_id);
alter table operations add constraint car_id_fk1 foreign key (car_id) references cars (car_id);
alter table operations add constraint delivery_order_id_fk foreign key (delivery_order_id) references delivery_orders (delivery_order_id);
alter table orders add constraint car_id_fk2 foreign key (car_id) references cars (car_id);
alter table orders add constraint client_id_fk foreign key (client_id) references clients (client_id);
alter table orders add constraint sale_id_fk foreign key (sale_id) references sale_descriptions (sale_id);