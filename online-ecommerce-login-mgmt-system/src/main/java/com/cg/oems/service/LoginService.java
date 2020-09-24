package com.cg.oems.service;

import com.cg.oems.entity.Login;
import com.cg.oems.exception.LoginException;

public interface LoginService {

	public String validate(String userName,String userPass) throws LoginException;
	public Login create(Login login) throws LoginException;

}
