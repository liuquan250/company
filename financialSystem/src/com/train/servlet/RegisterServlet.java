package com.train.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.train.bean.Register;
import com.train.service.RegisterService;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		RegisterService rs=new RegisterService();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phonenumber=request.getParameter("phonenumber");
		try {
			Register register=rs.register(uname, password, email, phonenumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("RegisterSuccess.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
