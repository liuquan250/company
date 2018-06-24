package com.train.service;

import java.sql.SQLException;

import com.train.bean.YZname;
import com.train.dao.YZnameDao;

public class YZnameService {
	YZnameDao yzd=new YZnameDao();
	public YZname yzname(String uname) throws SQLException{
		return yzd.yzname(uname);
		
	}
}
