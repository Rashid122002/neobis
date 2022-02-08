USE cardealership;
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