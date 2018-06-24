package com.train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.YZname;

public class YZnameDao {
	public  YZname yzname(String uname) throws SQLException{
		YZname yz=null;
		
		//创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //从连接池对象中获取数据库连接
        Connection conn=dataSource.getConnection();
		
		String sql="select uname from UserInfo where uname='"+uname+"' ";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			yz=new YZname();
			yz.setUname(rs.getString("uname"));
		}
		return yz;
	
		
	}
}
