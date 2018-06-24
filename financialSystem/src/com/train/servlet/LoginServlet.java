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
			
			out.print("<script>alert('用户名或密码不能为空!');window.location.href='Login.html'</script>");
		}else{
			Login ln;
			try {
				ln = ls.login(uname, password);
				System.out.println("1111111111111:"+ln);
				if(ln==null){
					PrintWriter out = response.getWriter();
					
					out.print("<script>alert('用户名或密码错误!');window.location.href='Login.html'</script>");
				}else{
					
					List newsList=new ArrayList();
					newsList.add(uname);
					System.out.println(newsList);
					PrintWriter out=response.getWriter();       //向客户端发送字符数据
				    response.setContentType("text/text");          //设置请求以及响应的内容类型以及编码方式
				    response.setCharacterEncoding("UTF-8");
					JSONArray  json = JSONArray.fromObject(newsList);   //将newsList对象转换为json对象
					String str = json.toString();                //将json对象转换为字符串
					out.write(str);                     //将str字符传输到前台       
					System.out.println(str);
					
					request.getSession().setAttribute("uname", uname);//将用户名放入session，供以后的servlet调用
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
