package com.train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Changemima;

public class ChangemimaDao {
	Changemima cha;
	public Changemima yanzheng(String uname,String oldpassword) throws SQLException{
		//�������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //�����ӳض����л�ȡ���ݿ�����
        Connection conn=dataSource.getConnection();
		String sql="select uname,password from UserInfo where uname='"+uname+"' and password='"+oldpassword+"' ";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs=ps.executeQuery();
       while(rs.next()){
			cha=new Changemima();
			cha.setUname(rs.getString("uname"));
			
		      }
	return cha;
	    }
	
	
	
	public Changemima change(String uname,String password) throws SQLException{
		//�������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //�����ӳض����л�ȡ���ݿ�����
        Connection conn=dataSource.getConnection();
		
		String sql="update UserInfo set password='"+password+"' where uname='"+uname+"' ";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		int rs=ps.executeUpdate();
		return null;
	}
}
