package com.cg.oems.dao;

import com.cg.oems.entity.Login;
import com.cg.oems.exception.LoginException;

public interface LoginDao {

	public Login validate(String userName,String userPass) throws LoginException;
	public Login create(Login login) throws LoginException;
	public Login findUser(String userName) throws LoginException;
	   
}
