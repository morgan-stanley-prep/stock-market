DROP SCHEMA IF EXISTS `stock-price-project`;

CREATE SCHEMA `stock-price-project`;

use `stock-price-project`;

DROP TABLE IF EXISTS `stock_price_table`;

CREATE TABLE `stock_price_table` (
  `stock_name` varchar(128) NOT NULL,
  `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `price` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
);

INSERT INTO stock_price_table(stock_name,price)
VALUES("Raymond",808.00),
("IIFL Holdings",136.85),
("IGL",418.15),
("Sterlite Tech",136.85),
("DLF",203.10);
