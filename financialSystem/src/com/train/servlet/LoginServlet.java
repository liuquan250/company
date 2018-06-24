package com.train.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.train.bean.Login;
import com.train.service.LoginService;

import net.sf.json.JSONArray;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("GBK");
		String CONTENT_TYPE = "text/html; charset=GBK";
		//response.setContentType("text/html;charset=utf-8");
		LoginService ls=new LoginService();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		if(uname.equals("")||password.equals("")){
			PrintWriter out = response.getWriter();
			
			out.print("<script>alert('�û��������벻��Ϊ��!');window.location.href='Login.html'</script>");
		}else{
			Login ln;
			try {
				ln = ls.login(uname, password);
				System.out.println("1111111111111:"+ln);
				if(ln==null){
					PrintWriter out = response.getWriter();
					
					out.print("<script>alert('�û������������!');window.location.href='Login.html'</script>");
				}else{
					
					List newsList=new ArrayList();
					newsList.add(uname);
					System.out.println(newsList);
					PrintWriter out=response.getWriter();       //��ͻ��˷����ַ�����
				    response.setContentType("text/text");          //���������Լ���Ӧ�����������Լ����뷽ʽ
				    response.setCharacterEncoding("UTF-8");
					JSONArray  json = JSONArray.fromObject(newsList);   //��newsList����ת��Ϊjson����
					String str = json.toString();                //��json����ת��Ϊ�ַ���
					out.write(str);                     //��str�ַ����䵽ǰ̨       
					System.out.println(str);
					
					request.getSession().setAttribute("uname", uname);//���û�������session�����Ժ��servlet����
					response.sendRedirect("Choose.html"); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
