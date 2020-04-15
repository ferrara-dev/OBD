create table IF NOT EXISTS CustomerDB( id  varchar(20) primary key, name varchar(20), email varchar(20),country varchar(20), password varchar(20) );
create table IF NOT EXISTS sales ( id  varchar(50) primary key, vdata JSON);


CREATE TABLE IF NOT EXISTS `products` (
`name` VARCHAR(MAX) NULL,
`amount` FLOAT NULL,
`unit` VARCHAR(MAX) NULL,
`price` INT NULL,
`category` VARCHAR(MAX) NULL,
`id` INT primary key,
`status` INT NULL
);

INSERT INTO products VALUES
('Chicken breast',1,'kg',79,'Viand',1,500),
('Apple',1,'pce',5,'Viand',2,500),
('Blueberries',0.25,'kg',40,'Viand',3,500),
('Grapes',1,'pce',35,'Viand',4,500),
('Milk',1,'pce',10,'Viand',5,200),
('Beer 2% alc',1,'pce',15,'Misc',6,500),
('News paper',1,'pce',30,'Literature',7,500);

INSERT INTO  CustomerDB VALUES
('940412-1395', 'Samuel', 'samuel@gmail.com', 'India', '123'),
('960404-6541', 'Deepa', 'deepa@gmail.com', 'India', '123'),
('711231-6325', 'Tom', 'top@gmail.com', 'India', '123');