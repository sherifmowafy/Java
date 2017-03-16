package com.sherif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sherif.entity.Customer;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {
	
	@PersistenceContext(unitName="pUnit")
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

	@Override
	public List<Customer> getAll(int pageNumber) {
		TypedQuery<Customer> query = em.createNamedQuery(Customer.SELECT_ALL_QUERY, Customer.class);
		int pageSize = 5;
		query.setFirstResult((pageNumber -1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	@Override
	public long countAll() {
		TypedQuery<Long> query = em.createNamedQuery(Customer.COUNT_ALL_QUERY, Long.class);
		return  query.getSingleResult();
	}

	

	
	
	
}
