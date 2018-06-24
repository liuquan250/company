package com.train.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Showincome
 */
@WebServlet("/Showincome")
public class Showincome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname=(String) request.getSession().getAttribute("uname");
		 String startDate = request.getParameter("startDate");
		 System.out.println("-------------"+startDate);
		String endDate=request.getParameter("endDate");
		System.out.println("----------"+endDate);
		try{
		//创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //从连接池对象中获取数据库连接
        Connection conn=dataSource.getConnection();
		
		String sql="select income,incometime,incomekind  from IncomeInfo where incometime>'"+startDate+"' and incometime<'"+endDate+"' and uname='"+uname+"' ";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs=ps.executeQuery();
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		while(rs.next()){
			jsonobj.put("income", rs.getString("income"));
			jsonobj.put("incometime", rs.getString("incometime").substring(0, 10));
			jsonobj.put("incomekind", rs.getString("incomekind"));
		
			jsonarray.add(jsonobj); 
		}
		// 输出数据
		  response.setHeader("Access-Control-Allow-Origin", "*");
	   		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		           out = response.getWriter();
		           out.println(jsonarray);
		           System.out.println(jsonarray);
		           
		   		out.flush();
		   		out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
