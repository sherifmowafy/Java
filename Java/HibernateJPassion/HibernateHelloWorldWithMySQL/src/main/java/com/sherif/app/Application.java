package com.sherif.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sherif.data.domain.Customer;
import com.sherif.data.domain.Order;
import com.sherif.data.domain.OrderDetails;
import com.sherif.data.domain.OrderDetailsId;
import com.sherif.data.domain.Product;

public class Application {



	public static void main(String[] args) {
		//AddOneToManyEntities();
		//ManyToOneCascadeRemove();
		ManyToManyWithExtraColumns();
	}
	
	public static void ManyToManyWithExtraColumns(){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("unit_name");
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Product product = em.find(Product.class, 1l);
		Order order = em.find(Order.class, 5l);
		
		OrderDetailsId odId = new OrderDetailsId();
		odId.setOrderId(order.getId());
		odId.setProductId(product.getId());
		
		OrderDetails orderDetails = em.find(OrderDetails.class, odId);
		
		
		
		System.out.println(product.getOrderDetails().size());
		System.out.println(order.getOrderDetails().size());
		
		System.out.println(orderDetails.getProduct().getName());
		
//		OrderDetails od = new OrderDetails();
//		
//		od.setOrderId(order.getId());
//		od.setProductId(product.getId());
//		od.setQuantity(10);
//		
//		transaction.begin();
//		
//		em.persist(od);
//		
//		transaction.commit();
		
	}

	public static void createJPAEntityManager() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("unit_name");
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		 
		Customer customer = new Customer();
		customer.setName("One To Many");
		customer.setRegDate(new Date());
		 
		
		
		 Order order = new Order();
		 order.setOrderDate(new Date());
		 order.setCustomer(customer);
		 
		 
		 
		 em.persist(order);
		 
		 transaction.commit();
//		Customer c = em.find(Customer.class, 1l);
//		em.remove(c);
		//em.getTransaction().commit();
//		Customer c = em.find(Customer.class, 1l);
//		System.out.println(c.getName());
//		
//		Order order = new Order();
//		order.setCustomer(c);
//		order.setOrderDate(new Date());
//		
//		transaction.begin();
//		em.persist(order);
//		transaction.commit();
		
		em.close();
	}
	
	public static void ManyToOneCascadeRemove(){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("unit_name");
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Order order = em.find(Order.class, 4l);
		em.remove(order);
		transaction.commit();
	}
	
	public static void AddOneToManyEntities(){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("unit_name");
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		 
		Customer customer = new Customer();
		customer.setName("One To Many");
		customer.setRegDate(new Date());
		 
		 List<Order> orders = new ArrayList<Order>();
		
		 Order order = new Order();
		 order.setOrderDate(new Date());
		 order.setCustomer(customer);
		 orders.add(order);
		 
		 customer.setOrders(orders);
		 
		 em.persist(customer);
		 
		 transaction.commit();
	}
	

	public static void createHibernateSession() {
		SessionFactory sessionFactory = null;
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("/config/hibernate.cfg.xml").build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// Create a Person object and save it
			Customer c1 = new Customer();
			c1.setName("Sherif Mowafy2");
			session.save(c1);
			tx.commit();
			tx = null;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
