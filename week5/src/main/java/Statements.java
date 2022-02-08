public enum Statements {
    SELECT_CLIENTS("SELECT * FROM clients"),
    INSERT_CLIENT("INSERT INTO clients (last_name, first_name, phone_number, notes) VALUES(?,?,?,?)"),
    UPDATE_CLIENT("UPDATE clients SET last_name=?, first_name=?, phone_number=?, notes=? WHERE client_id=?"),
    DELETE_CLIENT("DELETE FROM clients WHERE client_id=?"),

    SELECT_CARS("SELECT * FROM Cars"),
    INSERT_CAR("INSERT INTO cars (car_brand, serial_number, year_of_manufacture, engine_capacity, car_color, price_id, notes) VALUES(?,?,?,?,?,?,?)"),
    UPDATE_CAR("UPDATE cars SET car_brand=?, serial_number=?, year_of_manufacture=?, " +
            "engine_capacity=?, car_color=?, price_id=?, notes=? WHERE car_id=?"),
    DELETE_CAR("DELETE FROM cars WHERE car_id=?"),

    SELECT_STAFF("SELECT * FROM staff"),
    INSERT_STAFF("INSERT INTO staff (last_name, first_name, position, phone_number) VALUES(?,?,?,?)"),
    UPDATE_STAFF("UPDATE staff SET last_name=?, first_name=?, position=?, phone_number=? WHERE staff_id=?"),
    DELETE_STAFF("DELETE FROM staff WHERE staff_id=?"),

    SELECT_PROVIDERS("SELECT * FROM providers"),
    INSERT_PROVIDER("INSERT INTO providers (company_name, company_official_name, position, address, city, phone_number, fax, payment_term) VALUES(?,?,?,?,?,?,?,?)"),
    UPDATE_PROVIDER("UPDATE providers SET company_name=?, company_official_name=?, position=?, address=?, city=?, phone_number=?, fax=?, payment_term=? WHERE provider_id=?"),
    DELETE_PROVIDER("DELETE FROM providers WHERE provider_id=?"),

    SELECT_PRICES("SELECT * FROM prices"),
    INSERT_PRICE("INSERT INTO prices (sale_price) VALUES(?)"),
    UPDATE_PRICE("UPDATE prices SET sale_price=? WHERE price_id=?"),
    DELETE_PRICE("DELETE FROM prices WHERE price_id=?"),

    SELECT_PURCHASE_DESCRIPTIONS("SELECT * FROM purchase_descriptions"),
    INSERT_PURCHASE_DESCRIPTION("INSERT INTO purchase_descriptions (purchase_description) VALUES(?)"),
    UPDATE_PURCHASE_DESCRIPTION("UPDATE purchase_descriptions SET purchase_description=? WHERE purchase_description_id=?"),
    DELETE_PURCHASE_DESCRIPTION("DELETE FROM purchase_descriptions WHERE purchase_description_id=?"),

    SELECT_SALE_DESCRIPTIONS("SELECT * FROM sale_descriptions"),
    INSERT_SALE_DESCRIPTION("INSERT INTO sale_descriptions (sale_description) VALUES(?)"),
    UPDATE_SALE_DESCRIPTION("UPDATE sale_descriptions SET sale_description=? WHERE sale_description_id=?"),
    DELETE_SALE_DESCRIPTION("DELETE FROM sale_descriptions WHERE sale_description_id=?"),

    SELECT_ORDERS("SELECT * FROM orders"),
    INSERT_ORDER("INSERT INTO orders (client_id, car_id, placement_date, order_number, document_type, document_number, address, sale_description_id) VALUES(?,?,?,?,?,?,?,?)"),
    UPDATE_ORDER("UPDATE orders SET client_id=?, car_id=?, placement_date=?, order_number=?, document_type=?, document_number=?, address=?, sale_description_id=? WHERE order_id=?"),
    DELETE_ORDER("DELETE FROM orders WHERE order_id=?"),

    SELECT_OPERATIONS("SELECT * FROM operations"),
    INSERT_OPERATION("INSERT INTO operations (operation_date, car_id, delivery_order_id, operation_description, factory_price, cost_up_to, total_amount) VALUES(?,?,?,?,?,?,?)"),
    UPDATE_OPERATION("UPDATE operations SET operation_date=?, car_id=?, delivery_order_id=?, operation_description=?, factory_price=?, cost_up_to=?, total_amount=? WHERE operation_id=?"),
    DELETE_OPERATION("DELETE FROM operations WHERE operation_id=?"),

    SELECT_DELIVERY_ORDERS("SELECT * FROM delivery_orders"),
    INSERT_DELIVERY_ORDER("INSERT INTO delivery_orders (order_description, provider_id, staff_id, placement_date, execution_date, purchase_description_id) VALUES(?,?,?,?,?,?)"),
    UPDATE_DELIVERY_ORDER("UPDATE delivery_orders SET order_description=?, provider_id=?, staff_id=?, placement_date=?, execution_date=?, purchase_description_id=? WHERE delivery_order_id=?"),
    DELETE_DELIVERY_ORDER("DELETE FROM delivery_orders WHERE delivery_order_id=?");

    String s;
    Statements(String s) {
        this.s = s;
    }
}
