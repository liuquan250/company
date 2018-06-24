package com.train.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.train.bean.Income;
import com.train.service.IncomeService;


@WebServlet("/IncomeServlet")
public class IncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IncomeService is=new IncomeService();
		
		String uname=(String) request.getSession().getAttribute("uname");
		String income=request.getParameter("income");
		String incomekind=request.getParameter("incomekind");
		String incometime=request.getParameter("incometime");
		try {
			Income in=is.income(uname, income, incomekind, incometime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Incomesuccess.html"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
