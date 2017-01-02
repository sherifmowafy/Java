CREATE database Store;

CREATE table Customers(id bigint NOT NULL AUTO_INCREMENT,
						Name varchar(30) NOT NULL,
						regDate DATETIME,
						PRIMARY KEY(id));
						
CREATE table Orders(id bigint NOT NULL AUTO_INCREMENT, customerId bigint NOT NULL, orderDate DATETIME NOT NULL,
					PRIMARY KEY(id),
					CONSTRAINT fk_Customer_Order_Id FOREIGN KEY (customerId) REFERENCES Customers(id)
					);