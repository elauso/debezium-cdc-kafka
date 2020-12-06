create database if not exists db_product;
use db_product;

create table if not exists products (
    `id` int(11) primary key auto_increment,
    `name` varchar(50) not null,
    `description` varchar(255),
    `type` ENUM ('AUTOMOTIVE', 'ELECTRONICS', 'BOOKS', 'OTHERS')
);