package com.cg.dao;

import java.util.List;

import com.cg.entity.Author;
import com.cg.exception.AuthorException;



public interface AuthorDao  {

	public int createAuthor(Author author) throws AuthorException;
	public Author findAuthorById(int authorId) throws AuthorException;
	public Author deleteAuthor(int authorId) throws AuthorException;
	public List<Author> listAllAuthor() throws AuthorException;
	public Author updateAuthor(Author author) throws AuthorException;
}
