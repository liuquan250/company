package com.train.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.train.bean.YZname;
import com.train.service.YZnameService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * @author Train
 *��֤�û����Ƿ��Ѿ�����servlet
 */
@WebServlet("/YZnameServlet")
public class YZnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YZnameService yzs=new YZnameService();
		
		String uname=request.getParameter("uname");
		System.out.println(uname);
		JSONObject jsonobj = new JSONObject(); 
		YZname yzname;
		try{
			
			yzname=yzs.yzname(uname);
			System.out.println("111111111:"+yzname);
			if(yzname==null){
				System.out.println("������");
				jsonobj.put("e", "0");
				
			}else{
				System.out.println("����");
				jsonobj.put("e", "1");
			}
			// �������
			  response.setHeader("Access-Control-Allow-Origin", "*");
		   		response.setContentType("text/html;charset=utf-8");
			 PrintWriter out = response.getWriter();
			           out = response.getWriter();
			           out.println(jsonobj);
			           System.out.println(jsonobj);
			           
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
