package com.sherif.service;

import com.sherif.entity.Customer;

public interface CustomerService {
	
	Customer get(long id);
	Customer save(Customer customer);

}
