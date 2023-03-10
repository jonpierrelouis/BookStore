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
UPDATE books SET inventory = inventory - 1 WHERE book_id = 1;

CREATE TABLE users(
user_id SERIAL PRIMARY KEY,
user_name varchar(50),
user_password varchar(50)
);

CREATE TABLE cart(
fk_user_id int,
fk_book_id int,
CONSTRAINT fkuserid FOREIGN KEY (fk_user_id) REFERENCES users (user_id),
CONSTRAINT fkbookid FOREIGN KEY (fk_book_id) REFERENCES books (book_id)
);

INSERT INTO users VALUES(DEFAULT, 'test1@gmail.com', 'password');
INSERT INTO users VALUES(DEFAULT, 'test2', 'password');

DELETE FROM cart WHERE fk_user_id = 1 AND fk_book_id = 1;

SELECT * FROM books;
SELECT * FROM users;
SELECT * FROM cart;