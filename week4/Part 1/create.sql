CREATE DATABASE cardealership;

USE cardealership;

CREATE TABLE cars (
  car_id int NOT NULL AUTO_INCREMENT,
  car_brand varchar(45) NOT NULL,
  serial_number varchar(45) NOT NULL,
  year_of_manufacture date NOT NULL,
  engine_capacity varchar(45) NOT NULL,
  car_color varchar(45) NOT NULL,
  notes varchar(45) DEFAULT NULL,
  PRIMARY KEY (car_id)
  );
  
CREATE TABLE clients (
  clients_id int NOT NULL AUTO_INCREMENT,
  last_name varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  phone_number varchar(45) NOT NULL,
  notes varchar(45) DEFAULT NULL,
  PRIMARY KEY (clients_id)
);

CREATE TABLE delivery_orders (
  delivery_order_id int NOT NULL AUTO_INCREMENT,
  order_description varchar(45) NOT NULL,
  placement_date date NOT NULL,
  execution_date date NOT NULL,
  PRIMARY KEY (delivery_order_id)
);

CREATE TABLE operations (
  operation_id int NOT NULL AUTO_INCREMENT,
  operation_date date NOT NULL,
  operation_description varchar(45) NOT NULL,
  factory_price double NOT NULL,
  cost_up_to double NOT NULL,
  total_amount double DEFAULT NULL,
  PRIMARY KEY (operation_id)
);

CREATE TABLE orders (
  order_id int NOT NULL AUTO_INCREMENT,
  placement_date date NOT NULL,
  order_number varchar(45) NOT NULL,
  document_type varchar(45) NOT NULL,
  document_number varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  PRIMARY KEY (order_id)
);

CREATE TABLE providers (
  provider_id int NOT NULL AUTO_INCREMENT,
  company_name varchar(45) NOT NULL,
  companu_official_name varchar(45) NOT NULL,
  position varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  city varchar(45) NOT NULL,
  phone_number varchar(45) NOT NULL,
  fax varchar(45) DEFAULT NULL,
  payment_term varchar(45) NOT NULL,
  PRIMARY KEY (provider_id)
);

CREATE TABLE staff (
  staff_id int NOT NULL AUTO_INCREMENT,
  last_name varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  position varchar(45) NOT NULL,
  phone_number varchar(45) NOT NULL,
  PRIMARY KEY (staff_id)
);

CREATE TABLE prices (
  price_id int NOT NULL AUTO_INCREMENT,
  sale_price double NOT NULL,
  PRIMARY KEY (price_id)
);

CREATE TABLE purchase_descriptions (
  purchase_id int NOT NULL AUTO_INCREMENT,
  description varchar(45) NOT NULL,
  PRIMARY KEY (purchase_id)
);

CREATE TABLE sale_descriptions (
  sale_id int NOT NULL AUTO_INCREMENT,
  description varchar(45) NOT NULL,
  PRIMARY KEY (sale_id)
);