package com.train.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Income;


public class IncomeDao {
	public Income income(String uname,String income,String incomekind,String incometime) throws SQLException{
		//�������ӳغ��Ĺ�����
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		//�����ӳض����л�ȡ���ݿ�����
		Connection conn=dataSource.getConnection();
		
		//���û��������������ʱ�����IncomeInfo����
		String sql="insert into IncomeInfo (uname,income,incometime,incomekind) values('"+uname+"','"+income+"','"+incometime+"','"+incomekind+"')";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		int rs=ps.executeUpdate();
		return null;
		
		
	}
}
