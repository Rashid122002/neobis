SELECT products.id, products.name FROM products
JOIN categories ON categories.id = products.id_categories
WHERE LEFT(categories.name, 5) = 'super'