package com.sherif.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherif.domain.Customer;
import com.sherif.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public Customer get(long id) {
		return customerRepository.get(id);
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

}
