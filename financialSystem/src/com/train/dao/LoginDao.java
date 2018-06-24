package com.train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Login;

public class LoginDao {
	Connection conn=null;
	Statement stmt =null;
	ResultSet rs=null;
	public Login getNamePwd(String uname,String password) throws SQLException{
		Login lg=null;
		
			
		//创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //从连接池对象中获取数据库连接
        Connection conn=dataSource.getConnection();
			String sql="select uname,password from UserInfo where uname='"+uname+"'and password='"+password+"'  ";
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				lg=new Login();
				lg.setUname(rs.getString("uname"));
				lg.setPassword(rs.getString("password"));
			}
		
		return lg;
	}
}
