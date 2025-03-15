INSERT INTO customers (name, surname, email, company, position, address, postal_code, region, phone, dob) VALUES ("Francisco Javier", "Jiménez Paredes", "fjavierjp@protonmail.com", "Red Hat", "Software engineer", "St. AH", "30303", "Acholand", "123456789", "1993-09-09");

INSERT INTO articles (name, description, price, stock, type, provider, date) VALUES ("FirstArticle", "This is the first article", 5.50, 10, 0, 0, "2025-03-03");

INSERT INTO purchases (customer_id, article_id, date, amount, net, taxes, total) VALUES (1, 1, "2025-03-12", 5, 27.5, 5.775, 33.275);