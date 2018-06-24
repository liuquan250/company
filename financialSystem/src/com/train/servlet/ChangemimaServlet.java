package com.train.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.train.bean.Changemima;
import com.train.dao.ChangemimaDao;


@WebServlet("/ChangemimaServlet")
public class ChangemimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChangemimaDao chd=new ChangemimaDao();
		Changemima chmima;
		String uname=(String)request.getSession().getAttribute("uname");
		System.out.println("�޸���������ȡ�����û�����"+uname);
		request.setCharacterEncoding("utf-8");
		String oldpassword=request.getParameter("oldpassword");
		System.out.println("oldpassword"+oldpassword);
		String password=request.getParameter("password");
		System.out.println("password"+password);
		try{
			chmima=chd.yanzheng(uname, oldpassword);
			if(chmima==null){
				JOptionPane.showMessageDialog(null, "ԭ�������");
				request.getRequestDispatcher("Changemima.html").forward(request, response);
			}else{
				Changemima ch=chd.change(uname, password);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ��������µ�½");
				request.getRequestDispatcher("Login.html").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
