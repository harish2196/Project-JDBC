create database product;
use product;
create table products(
 id INT NOT NULL,
  name VARCHAR(255),
  model Varchar(255),
  price double
);

select id,name,model,price from products ORDER BY id ASC;
DELETE FROM products WHERE id=2;
drop Table products;
INSERT INTO products (id, name, model, price) VALUES (2, 'Harish', 'HSG', 1400.00);
SELECT COUNT(*) FROM products WHERE id = 2
create table user_register(id int(10)  auto_increment ,
name varchar(20) not null,
password varchar(20) not null,
  PRIMARY KEY (id));
desc user_register;
select id,name,password from user_register;
drop Table user_register;