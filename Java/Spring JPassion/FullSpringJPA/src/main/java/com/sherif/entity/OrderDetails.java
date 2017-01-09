package com.sherif.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetails")
@IdClass(value=OrderDetailsId.class)
public class OrderDetails {

	@Id
	private long productId;
	@Id
	private long orderId;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="productId", referencedColumnName="Id", insertable=false, updatable=false)
	private Product product;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="orderId", referencedColumnName="Id", insertable=false, updatable=false)
	private Order order;
	
	private long quantity;


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	
}
