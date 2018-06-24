package com.train.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Income;


public class IncomeDao {
	public Income income(String uname,String income,String incomekind,String incometime) throws SQLException{
		//创建连接池核心工具类
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		//从连接池对象中获取数据库连接
		Connection conn=dataSource.getConnection();
		
		//将用户名，收入金额，收入时间放入IncomeInfo表中
		String sql="insert into IncomeInfo (uname,income,incometime,incomekind) values('"+uname+"','"+income+"','"+incometime+"','"+incomekind+"')";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		int rs=ps.executeUpdate();
		return null;
		
		
	}
}
