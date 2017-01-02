package com.sherif.app;

import java.util.Date;

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

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {
		createJPAEntityManager();

	}

	public static void createJPAEntityManager() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("unit_name");
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		 Customer c1 = new Customer();
		 c1.setName("Sherif Mowafy");
		 c1.setRegDate(new Date());
		 em.persist(c1);
		 transaction.commit();
//		Customer c = em.find(Customer.class, 1l);
//		em.remove(c);
		//em.getTransaction().commit();
		Customer c = em.find(Customer.class, 1l);
		System.out.println(c.getName());
		
		Order order = new Order();
		order.setCustomer(c);
		order.setOrderDate(new Date());
		
		transaction.begin();
		em.persist(order);
		transaction.commit();
		
		em.close();
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
