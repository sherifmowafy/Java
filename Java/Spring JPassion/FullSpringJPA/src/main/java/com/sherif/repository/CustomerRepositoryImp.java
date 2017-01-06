package com.sherif.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sherif.domain.Customer;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {
	
	@PersistenceContext(unitName="storePUnit")
	private EntityManager em;

	
	@Override
	public Customer get(long id) {
		return em.find(Customer.class, id);
	}
	
	@Override
	public Customer save(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete(Customer customer) {
		em.remove(customer);
	}

	

	
	
	
}
