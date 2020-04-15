create table IF NOT EXISTS CustomerDB( id  varchar(20) primary key, name varchar(20), email varchar(20),country varchar(20), password varchar(20) );


create table IF NOT EXISTS sales( id  varchar(20) primary key, json blob);

INSERT INTO  CustomerDB VALUES ('940412-1395', 'Samuel', 'samuel@gmail.com', 'India', '123'),('960404-6541', 'Deepa', 'deepa@gmail.com', 'India', '123'),('711231-6325', 'Tom', 'top@gmail.com', 'India', '123');