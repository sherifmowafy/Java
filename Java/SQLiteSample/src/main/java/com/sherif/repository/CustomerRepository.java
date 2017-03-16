package com.sherif.repository;

import java.util.List;

import com.sherif.entity.Customer;

public interface CustomerRepository {
	
	Customer get(long id);
	Customer save(Customer customer);
	void delete(Customer customer);
	List<Customer> getAll(int page);
	long countAll();

}
