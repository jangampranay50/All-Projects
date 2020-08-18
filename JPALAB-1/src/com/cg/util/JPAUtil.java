package com.cg.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
public static EntityManager getEntitymanager()
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
	   EntityManager entityManager =entityManagerFactory.createEntityManager();
	   return entityManager;
}
}
