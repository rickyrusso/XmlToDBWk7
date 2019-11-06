/** create the stocks database */

DROP DATABASE stocks;
CREATE DATABASE stocks;

CREATE TABLE stocks.quotes(
   ID INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);