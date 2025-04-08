-- 1-  (Re)Create tables
drop table customer if exists;


create table customer
(
    customer_number   BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_name     CHARACTER VARYING(50) NOT NULL,
    customer_mobile   CHARACTER VARYING(20) NOT NULL,
    customer_email    CHARACTER VARYING(50) NOT NULL,
    address1         CHARACTER VARYING(100) NOT NULL,
    address2         CHARACTER VARYING(100),
    account_type     ENUM('S', 'C')
);


-- 2- Insert data into tables
-- customer					
insert into customer(customer_number,customer_name, customer_mobile, customer_email,address1,address2,account_type)
values (1001,'aris', '9172314444','aris@gmail.com','Taguig City','','S');

insert into customer(customer_number, customer_name, customer_mobile, customer_email,address1,address2,account_type)
values (1002,'zeke', '9171234567','zeke@yahoo.com','Makati City','','C');


