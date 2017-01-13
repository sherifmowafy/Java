package com.sherif.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name= Customer.SELECT_ALL_QUERY, query="SELECT e FROM Customer e"),
	@NamedQuery(name= Customer.COUNT_ALL_QUERY, query="SELECT COUNT(e.id) FROM Customer e")
})

@Entity
@Table(name="Customers")
public class Customer {
	
	public static final String SELECT_ALL_QUERY = "SELECT_ALL_QUERY";
	public static final String COUNT_ALL_QUERY = "COUNT_ALL_QUERY";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Date regDate;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
	private List<Order> orders ;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
