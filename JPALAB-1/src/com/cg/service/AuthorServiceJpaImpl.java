package com.cg.service;

import java.util.List;

import com.cg.dao.AuthorDao;
import com.cg.dao.AuthorDaoJpaImpl;

import com.cg.entity.Author;
import com.cg.exception.AuthorException;

public class AuthorServiceJpaImpl implements AuthorService {
 private AuthorDao authorDao = new AuthorDaoJpaImpl();
		
	
	@Override
	public int createAuthor(Author author) throws AuthorException {
		boolean flag = (author.getFirstName().matches("[a-zA-z]+"))&&(author.getMiddleName().matches("[a-zA-z]+"))&&(author.getLastName().matches("[a-zA-z]+"));
		if(!flag)
		{
			throw new AuthorException("name should contain only chaacters");
		}
		String phoneNo = String.valueOf(author.getPhoneNo());
		boolean  flag1 = phoneNo.matches("[1-9][0-9]{9}");
		if(!flag1)
		{
			throw new AuthorException("phone number should contain only numbers and it should be 10 digits only");
		}
		
		return authorDao.createAuthor(author) ;
	}

	@Override
	public Author findAuthorById(int authorId) throws AuthorException {
		String id = String.valueOf(authorId);
		boolean  flag1 = id.matches("[0-9]+");
		if(!flag1)
		{
			throw new AuthorException("Author id should be 4 digits only");
		}
		return authorDao.findAuthorById(authorId);
	}

	@Override
	public Author deleteAuthor(int authorId) throws AuthorException {
		String id = String.valueOf(authorId);
		boolean  flag1 = id.matches("[0-9]+");
		if(!flag1)
		{
			throw new AuthorException("Author id should be 4 digits only");
		}
		return authorDao.deleteAuthor(authorId);
	}

	@Override
	public List<Author> listAllAuthor() throws AuthorException {
		
		return authorDao.listAllAuthor();
	}

	@Override
	public Author updateAuthor(Author author) throws AuthorException {
		String id = String.valueOf(author.getAuthorId());
		boolean  flag1 = id.matches("[0-9]+");
		if(!flag1)
		{
			throw new AuthorException("Author id should be 4 digits only");
		}
		boolean flag = (author.getFirstName().matches("[a-zA-Z]+"))&&(author.getMiddleName().matches("[a-zA-Z]+"))&&(author.getLastName().matches("[a-zA-Z]+"));
		if(!flag)
		{
			throw new AuthorException("name should contain only chaacters");
		}
		String phoneNo = String.valueOf(author.getPhoneNo());
		boolean  flag2 = phoneNo.matches("[1-9][0-9]{9}");
		if(!flag2)
		{
			throw new AuthorException("phone number should contain only numbers and it should be 10 digits only");
		}
		return authorDao.updateAuthor(author);
	}

}
