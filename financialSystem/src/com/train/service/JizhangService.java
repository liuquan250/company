package com.train.service;

import java.sql.Date;
import java.sql.SQLException;

import com.train.bean.Jizhang;
import com.train.dao.JizhangDao;

public class JizhangService {
	JizhangDao jd=new JizhangDao();
	public Jizhang jz(float price,int number,String cuspeople,String cusplace,String paykind,String bussiness,String cuskind,String custime,String remark,String uname) throws SQLException{
		return jd.jz(price, number, cuspeople, cusplace, paykind, bussiness, cuskind, custime, remark,uname);
	}
}
