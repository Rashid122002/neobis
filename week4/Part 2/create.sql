CREATE DATABASE cardealership;

USE cardealership;

CREATE TABLE cars (
  car_id INT UNSIGNED AUTO_INCREMENT,
  car_brand VARCHAR(45) NOT NULL,
  serial_number VARCHAR(45) NOT NULL,
  year_of_manufacture DATE NOT NULL,
  engine_capacity VARCHAR(45) NOT NULL,
  car_color VARCHAR(45) NOT NULL,
  price_id INT UNSIGNED NOT NULL,
  notes VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (car_id)
  );
  
CREATE TABLE clients (
  client_id INT UNSIGNED AUTO_INCREMENT,
  last_name VARCHAR(45) NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  notes VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (client_id)
);

CREATE TABLE delivery_orders (
  delivery_order_id INT UNSIGNED AUTO_INCREMENT,
  order_description VARCHAR(45) NOT NULL,
  provider_id INT UNSIGNED NOT NULL,
  staff_id INT UNSIGNED NOT NULL,
  placement_date DATE NOT NULL,
  execution_date DATE NOT NULL,
  purchase_description_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (delivery_order_id)
);

CREATE TABLE operations (
  operation_id INT UNSIGNED AUTO_INCREMENT,
  operation_date DATE NOT NULL,
  car_id INT UNSIGNED NOT NULL,
  delivery_order_id INT UNSIGNED NOT NULL,
  operation_description VARCHAR(45) NOT NULL,
  factory_price DOUBLE NOT NULL,
  cost_up_to DOUBLE NOT NULL,
  total_amount DOUBLE DEFAULT NULL,
  PRIMARY KEY (operation_id)
);

CREATE TABLE orders (
  order_id INT UNSIGNED AUTO_INCREMENT,
  client_id INT UNSIGNED NOT NULL,
  car_id INT UNSIGNED NOT NULL,
  placement_date DATE NOT NULL,
  order_number VARCHAR(45) NOT NULL,
  document_type VARCHAR(45) NOT NULL,
  document_number VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  sale_description_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (order_id)
);

CREATE TABLE providers (
  provider_id INT UNSIGNED AUTO_INCREMENT,
  company_name VARCHAR(45) NOT NULL,
  company_official_name VARCHAR(45) NOT NULL,
  position VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  city VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  fax VARCHAR(45) DEFAULT NULL,
  payment_term VARCHAR(45) NOT NULL,
  PRIMARY KEY (provider_id)
);

CREATE TABLE staff (
  staff_id INT UNSIGNED AUTO_INCREMENT,
  last_name VARCHAR(45) NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  position VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  PRIMARY KEY (staff_id)
);

CREATE TABLE prices (
  price_id INT UNSIGNED AUTO_INCREMENT,
  sale_price DOUBLE NOT NULL,
  PRIMARY KEY (price_id)
);

CREATE TABLE purchase_descriptions (
  purchase_description_id INT UNSIGNED AUTO_INCREMENT,
  purchase_description VARCHAR(45) NOT NULL,
  PRIMARY KEY (purchase_description_id)
);

CREATE TABLE sale_descriptions (
  sale_description_id INT UNSIGNED AUTO_INCREMENT,
  sale_description VARCHAR(45) NOT NULL,
  PRIMARY KEY (sale_description_id)
);

ALTER TABLE cars
 ADD CONSTRAINT price_id_fk
 FOREIGN KEY (price_id)
 REFERENCES prices(price_id);

ALTER TABLE delivery_orders
 ADD CONSTRAINT provider_id_fk
 FOREIGN KEY (provider_id)
 REFERENCES providers(provider_id);
ALTER TABLE delivery_orders
 ADD CONSTRAINT staff_id_fk
 FOREIGN KEY (staff_id)
 REFERENCES staff(staff_id);
ALTER TABLE delivery_orders
 ADD CONSTRAINT purchase_description_id_fk
 FOREIGN KEY (purchase_description_id)
 REFERENCES purchase_descriptions(purchase_description_id);

ALTER TABLE operations
 ADD CONSTRAINT car_id_fk1
 FOREIGN KEY (car_id)
 REFERENCES cars(car_id);
ALTER TABLE operations
 ADD CONSTRAINT delivery_order_id_fk
 FOREIGN KEY (delivery_order_id)
 REFERENCES delivery_orders(delivery_order_id);

ALTER TABLE orders
 ADD CONSTRAINT client_id_fk
 FOREIGN KEY (client_id)
 REFERENCES clients(client_id);
ALTER TABLE orders
 ADD CONSTRAINT car_id_fk2
 FOREIGN KEY (car_id)
 REFERENCES cars(car_id);
ALTER TABLE orders
 ADD CONSTRAINT sale_description_id_fk
 FOREIGN KEY (sale_description_id)
 REFERENCES sale_descriptions(sale_description_id);