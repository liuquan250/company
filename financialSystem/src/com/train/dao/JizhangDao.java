package com.train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Jizhang;

public class JizhangDao {
	public Jizhang jz(float price,int number,String cuspeople,String cusplace,String paykind,String bussiness,String cuskind,String custime,String remark,String uname) throws SQLException{
		
		 //��һ�����������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        
        //�������������ӳض����л�ȡ���ݿ�����
        Connection conn=dataSource.getConnection();
        float totalprice=price*number;
        String sql="insert into CusInfo (price, number, cuspeople, cusplace, paykind, bussiness, cuskind, custime, remark,totalprice,uname) values('"+price+"','"+number+"','"+cuspeople+"','"+cusplace+"','"+paykind+"','"+bussiness+"','"+cuskind+"','"+custime+"','"+remark+"','"+totalprice+"','"+uname+"')";
        PreparedStatement ps=conn.prepareStatement(sql);
        int rs=ps.executeUpdate();
        System.out.println(rs);
		return null;
	}
}
