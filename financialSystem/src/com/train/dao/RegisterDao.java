package com.train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Register;

public class RegisterDao {
	Connection conn=null;
	Statement stmt=null;
	
	public Register register(String uname,String password,String email,String phonenumber) throws SQLException{
		Register rt=null;
		
		//�������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //�����ӳض����л�ȡ���ݿ�����
        Connection conn=dataSource.getConnection();
		
			String sql="insert into UserInfo (uname,password,email,phonenumber) values('"+uname+"','"+password+"','"+email+"','"+phonenumber+"')";
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println(sql);
			int rs=ps.executeUpdate();
			
		return rt;
	}
}
