SELECT categories.name, SUM(products.amount) FROM products
JOIN categories ON categories.id = products.id_categories
GROUP BY categories.name