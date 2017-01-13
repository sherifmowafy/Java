package com.sherif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherif.entity.Customer;
import com.sherif.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer get(long id) {
		return customerRepository.get(id);
	}

	@Override
	public List<Customer> getAll(int pageNumber) {
		return customerRepository.getAll(pageNumber);
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Customer customer = customerRepository.get(id);
		customerRepository.delete(customer);
	}

	@Override
	@Transactional
	public Customer edit(Customer customer){
		Customer managedCustomer = get(customer.getId());
		managedCustomer.setName(customer.getName());
		return managedCustomer;
	}

	@Override
	public int getPagesCount() {
		long customersCount = customerRepository.countAll();
		int pageSize = 2;
		float pagesCount = customersCount / pageSize;
		int result = (int) (((pagesCount % 1) == 0) ? pagesCount : pagesCount +1) ;
		return result;
	}
	


}
