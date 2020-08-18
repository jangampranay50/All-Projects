package com.cg.pl;

import java.util.List;
import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Author;
import com.cg.exception.AuthorException;
import com.cg.service.AuthorService;
import com.cg.service.AuthorServiceJpaImpl;



public class Client {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		AuthorService service = new AuthorServiceJpaImpl();
		Author author =null;
		int choice=0;
		 Scanner scanner = new Scanner(System.in);
		em.getTransaction().begin();
		while(choice!=7)
		 {
		 System.out.println("1.Add Author");
		 System.out.println("2.Search Author");
		 
		 System.out.println("3.Update Author");
		 System.out.println("4.Delete  Author");
		 System.out.println("5.list of Authors");
		 System.out.println("6.Exit");
		 
		 System.out.println(" Enter your choice ");
		 choice =scanner.nextInt();
		 
		 switch(choice)
		 {
		 case 1 :
		try
		{
			 scanner.nextLine();
			 System.out.println("enter Author first name");
			 String fname =scanner.nextLine();
			 System.out.println("enter Author middle name");
			 String mname= scanner.nextLine();
			 System.out.println("enter last name");
			 String lname = scanner.nextLine();
			 System.out.println("enter phone no.");
			 long phno =scanner.nextLong();
			 author= new Author(0,fname,mname,lname,phno);
			 service.createAuthor(author);
			 System.out.println("Author Added successfully");
			 System.out.println(author);
		}
		catch(AuthorException e)
		{
			System.out.println(e.getMessage());
		}
              break;
		 case 2: 
			 System.out.println("enter author id");
			try
			{
				int authorId = scanner.nextInt();
			
			  author =service.findAuthorById(authorId);
			  System.out.println("author Found"+author);
			}
			catch(AuthorException e)
			{
				System.out.println(e.getMessage());
			}
			  
				 break;
		 case 3: 
			 try
			 {
			 System.out.println("enter author id");
			 int authorId = scanner.nextInt();
			 
					scanner.nextLine();
					 System.out.println("enter Author first name");
					String fname =scanner.nextLine();
					 System.out.println("enter Author middle name");
					  String mname= scanner.nextLine();
					 System.out.println("enter last name");
					String  lname = scanner.nextLine();
					 System.out.println("enter phone no.");
					 long phno =scanner.nextLong();
					 author =new Author(authorId,fname,mname,lname,phno);
					 Author author1 = service.updateAuthor(author);
                  System.out.println("updated employee details"+author1);
				}
			 catch(AuthorException e)
			 {
					System.out.println(e.getMessage());
				}
				 break;
		 case 4:
			 try
			 {
			 System.out.println("enter author id");
			  int authorId = scanner.nextInt();
			 author = service.deleteAuthor(authorId);
			 }
			 catch(AuthorException e)
			 {
					System.out.println(e.getMessage());
				}
			 
				 break;
		 case 5 :
			 try
			 {
			 List<Author> list =service.listAllAuthor();
				
				for(Author auth :  list)
				{
					System.out.println(auth);
				}
			 }
			 catch(AuthorException e)
			 {
				 System.out.println(e.getMessage());
			 }
			 break;
		 case 6: System.out.println("thank you ");
		        return;
			 
			 
			 
		 }
		 }
		

	}

}
