package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.util.JPAUtil;

import com.cg.entity.Author;
import com.cg.exception.AuthorException;

public class AuthorDaoJpaImpl implements AuthorDao {
   
	EntityManager em = JPAUtil.getEntitymanager(); 
	
	@Override
	public int createAuthor(Author author) throws AuthorException {
		
		em.getTransaction().begin();
		em.persist(author);
	      em.getTransaction().commit();
	    
		return author.getAuthorId();
	}

	@Override
	public Author findAuthorById(int authorId) throws AuthorException {
		
		Author author =em.find(Author.class,authorId);
		   if(author==null)
		   {
			  throw new AuthorException("Id not found");
		   }
		return author;
	}

	@Override
	public Author deleteAuthor(int authorId) throws AuthorException {
		em.getTransaction().begin();
		Author author =em.find(Author.class,authorId);
		   if(author==null)
		   {
			   throw new AuthorException(authorId+" Id not found");
			   
			  // System.out.println("employee removed");
		   }
		   
			   em.remove(author); 
		   
		   em.getTransaction().commit();
		return author;
	}

	@Override
	public List<Author> listAllAuthor() throws AuthorException {
String query="select a from Author a";
		
		TypedQuery<Author> qry = em.createQuery(query,Author.class);
		
		List<Author> list = qry.getResultList();
		return list;
	}

	@Override
	public Author updateAuthor(Author author) throws AuthorException {
		em.getTransaction().begin();
		 Author author1 =em.find(Author.class,author.getAuthorId());
		   if(author1==null)
		   {
			   
			   throw new AuthorException(" Id not found");  
			  
		   }
		   author1.setAuthorId(author.getAuthorId());
		  author1.setFirstName(author.getFirstName());
			 author1.setLastName(author.getLastName());
			 author1.setMiddleName(author.getMiddleName());
			 author1.setPhoneNo(author.getPhoneNo());
			 
			   em.merge(author1);
		   em.getTransaction().commit();
		return author1;
	}

}
