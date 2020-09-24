package com.cg.omms.exception;

//custom exception class extends to exception class
public class MovieException extends Exception{
	
	public MovieException(String message)
	{
		super(message);
	}
	public MovieException()
	{
		super();
	}

}
