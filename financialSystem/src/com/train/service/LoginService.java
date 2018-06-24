package com.train.service;

import java.sql.SQLException;

import com.train.bean.Login;
import com.train.dao.LoginDao;

public class LoginService {
	LoginDao ld=new LoginDao();
	public Login login(String uname,String password) throws SQLException{
		return ld.getNamePwd(uname, password);
	}
}
