package com.sherif.service;

import java.util.List;

import com.sherif.entity.Customer;

public interface CustomerService {
	
	Customer get(long id);
	List<Customer> getAll(int pageNumber);
	Customer save(Customer customer);
	void delete(long id);
	Customer edit(Customer customer);
	int getPagesCount();

}
