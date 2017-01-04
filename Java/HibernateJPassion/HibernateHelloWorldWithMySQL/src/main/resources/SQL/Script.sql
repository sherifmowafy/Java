CREATE database Store;

CREATE table Customers(id bigint NOT NULL AUTO_INCREMENT,
						Name varchar(30) NOT NULL,
						regDate DATETIME,
						PRIMARY KEY(id));
						
CREATE table Orders(id bigint NOT NULL AUTO_INCREMENT, customerId bigint NOT NULL, orderDate DATETIME NOT NULL,
					PRIMARY KEY(id),
					CONSTRAINT fk_Customer_Order_Id FOREIGN KEY (customerId) REFERENCES Customers(id)
					);
					
CREATE table Products(id bigint NOT NULL AUTO_INCREMENT,
					name varchar(30) NOT NULL,
					PRIMARY KEY(id));	
					
					
CREATE table OrderDetails(productId bigint NOT NULL,
						  orderId bigint NOT NULL,
						  quantity bigint NOT NULL,
						  PRIMARY KEY(productId, orderId),
						  CONSTRAINT fk_OrderDerails_Order_Id FOREIGN KEY (orderId) REFERENCES Orders(id),
						  CONSTRAINT fk_OrderDerails_Product_Id FOREIGN KEY (productId) REFERENCES Products(id)
							
						  );
						  
