create table IF NOT EXISTS CustomerDB( id  varchar(20) primary key, name varchar(20), email varchar(20),country varchar(20), password varchar(20));
create table IF NOT EXISTS ProductDB( id  varchar(20) primary key, name varchar(20), price varchar(20), category varchar(20), stockstatus varchar(20) );
create table IF NOT EXISTS discountDB( available  varchar(256) , type varchar(256), id varchar(256), requierment varchar(256), reduction varchar(256), limitation varchar (256));
create table IF NOT EXISTS products( id  varchar(50) primary key, vdata JSON);
create table IF NOT EXISTS sales( id  varchar(50) primary key, vdata JSON);
create table IF NOT EXISTS customerDiscounts( id  varchar(50) primary key, vdata JSON);
create table IF NOT EXISTS discountdatabase( id  varchar(50) primary key, vdata JSON);

INSERT INTO ProductDB VALUES
('1', 'chicken', '79', 'Viand', '500'),
('2', 'Apple', '5', 'Viand', '500'),
('3', 'Blueberries', '40', 'Viand', '500'),
('4', 'Grapes', '35', 'Viand', '500'),
('5', 'Milk', '10', 'Viand', '500'),
('6', 'Beer', '15', 'Misc', '500'),
('7', 'News paper', '30', 'Literature', '500');


INSERT INTO discountDB VALUES('MONDAY', 'Buy N Items Get N Free', '1' ,'3', '1', '1'),('TUESDAY', 'Bulk Discount', '2', '10', '0.20', '-1'),('WEDNESDAY', 'Buy N Items Get N Free', '3', '3', '1', '1'),('THURSDAY', 'Bulk Discount', '4', '5', '0.10', '-1'),('FRIDAY', 'Buy N Items Get N Free', '5', '5', '2', '3'),('SATURDAY', 'Price Discount', '6:3:1', '1', '0.15', '-1'),('MONDAY:TUESDAY:WEDNESDAY:THURSDAY:FRIDAY', 'Price Discount', '0', '500', '0.10', '1');

INSERT INTO products VALUES('1',null);
INSERT INTO customerDiscounts VALUES('940412-1395',null),('960404-6541',null),('711231-6325',null);

INSERT INTO  CustomerDB VALUES
('940412-1395', 'Samuel', 'samuel@gmail.com', 'India', '123'),
('960404-6541', 'Deepa', 'deepa@gmail.com', 'India', '123'),
('711231-6325', 'Tom', 'top@gmail.com', 'India', '123');