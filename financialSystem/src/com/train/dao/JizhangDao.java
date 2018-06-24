package com.train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Jizhang;

public class JizhangDao {
	public Jizhang jz(float price,int number,String cuspeople,String cusplace,String paykind,String bussiness,String cuskind,String custime,String remark,String uname) throws SQLException{
		
		 //第一步：创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        
        //第三步：从连接池对象中获取数据库连接
        Connection conn=dataSource.getConnection();
        float totalprice=price*number;
        String sql="insert into CusInfo (price, number, cuspeople, cusplace, paykind, bussiness, cuskind, custime, remark,totalprice,uname) values('"+price+"','"+number+"','"+cuspeople+"','"+cusplace+"','"+paykind+"','"+bussiness+"','"+cuskind+"','"+custime+"','"+remark+"','"+totalprice+"','"+uname+"')";
        PreparedStatement ps=conn.prepareStatement(sql);
        int rs=ps.executeUpdate();
        System.out.println(rs);
		return null;
	}
}
