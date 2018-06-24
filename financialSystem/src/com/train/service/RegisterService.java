package com.train.service;

import java.sql.SQLException;

import com.train.bean.Register;
import com.train.dao.RegisterDao;

public class RegisterService {
	RegisterDao rd=new RegisterDao();
	public Register register(String uname,String password,String email,String phonenumber) throws SQLException{
		return rd.register(uname, password, email, phonenumber);
		
	}
}
