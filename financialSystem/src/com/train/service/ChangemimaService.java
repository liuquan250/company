package com.train.service;

import java.sql.SQLException;

import com.train.bean.Changemima;
import com.train.dao.ChangemimaDao;

public class ChangemimaService {
ChangemimaDao chd=new ChangemimaDao();
public Changemima yz(String uname,String oldpassword) throws SQLException{
	return chd.yanzheng(uname, oldpassword);
	
}

public Changemima chmima(String uname,String password) throws SQLException{
	return chd.change(uname, password);
	
}
}
