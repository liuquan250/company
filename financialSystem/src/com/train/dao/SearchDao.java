package com.train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Search;

public class SearchDao {
	public Search search(String startDate,String endDate) throws SQLException{
		
		//创建连接池核心工具类
		ComboPooledDataSource dataSource=new ComboPooledDataSource("sqlserverPool");
		//从连接池对象中获取数据库连接
		Connection conn=dataSource.getConnection();
		String sql="select cuspeople,price,number,cusplace,paykind,bussiness,cuskind,custime,remark ,totalprice from CusInfo where custime>='"+startDate+"' and custime<='"+endDate+"' ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		System.out.println(sql);
		List list=new ArrayList();
		while(rs.next()){
			Search se=new Search();
			se.setBussiness(rs.getString("bussiness"));
			se.setCuskind(rs.getString("cuskind"));
			se.setCuspeople(rs.getString("cuspeople"));
			se.setCusplace(rs.getString("cusplace"));
			se.setCustime(rs.getString("custime"));
			se.setNumber(rs.getInt("number"));
			se.setPaykind(rs.getString("paykind"));
			se.setPrice(rs.getFloat("price"));
			se.setRemark(rs.getString("remark"));
			se.setTotalprice(rs.getString("totalprice"));
			list.add(se);
		}
		System.out.println(list);
		return null;
	}
}
