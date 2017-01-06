package com.sherif.repository;

import com.sherif.domain.Customer;

public interface CustomerRepository {
	
	Customer get(long id);
	Customer save(Customer customer);
	void delete(Customer customer);

}
