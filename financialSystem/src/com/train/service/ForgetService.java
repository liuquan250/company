package com.train.service;

import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.train.bean.Forget;
import com.train.dao.ForgetDao;

public class ForgetService {
	ForgetDao forgetDao=new ForgetDao();
	public Forget fg(String uname,String email,String phonenumber) throws AddressException, MessagingException, SQLException{
		return forgetDao.forget(uname, email, phonenumber);
	}
}
