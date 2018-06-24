package com.train.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.train.bean.Forget;
import com.train.service.ForgetService;


@WebServlet("/ForgetServlet")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ForgetService fs=new ForgetService();
		String uname=request.getParameter("uname");
		System.out.println(uname);
		String email=request.getParameter("email");
		System.out.println(email);
		String phonenumber=request.getParameter("phonenumber");
		try {
			Forget fg=fs.fg(uname, email, phonenumber);
			if(fg!=null){
				response.sendRedirect("Jump.html"); 
			}
			else{
				response.sendRedirect("ForgetFail.html"); 
			}
		} catch (MessagingException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
