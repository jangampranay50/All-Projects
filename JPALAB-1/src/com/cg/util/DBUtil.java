package com.cg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		 String  user ="hr";
		   String  pass ="hr";
		   String url="jdbc:oracle:thin:@localhost:1521:xe";
		   String className = "oracle.jdbc.driver.OracleDriver";
		   Connection connection=null;
		   Class.forName(className);
		   connection = DriverManager.getConnection(url,user,pass);
		   return connection;
	}

}
