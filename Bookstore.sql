CREATE TABLE books(
book_id SERIAL PRIMARY KEY,
book_name varchar(30) NOT NULL,
book_author varchar(30) NOT NULL,
book_genre varchar(30),
book_price decimal(10,2) NOT NULL,
book_picture bytea
);

ALTER TABLE books ADD inventory int;
UPDATE books SET inventory = 100;

CREATE TABLE users(
user_id SERIAL PRIMARY KEY,
user_name varchar(50),
user_password varchar(50)
);

INSERT INTO users VALUES(DEFAULT, 'test1', 'password');
INSERT INTO users VALUES(DEFAULT, 'test2', 'password');

SELECT * FROM books;
SELECT * FROM users;