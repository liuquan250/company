package com.train.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.train.bean.Jizhang;
import com.train.service.JizhangService;
/**
 * 个人理财系统记账模块servlet
 * 负责处理前端页面上传入的记账信息，包括以下信息
 * price;  //商品单价（float）
	 number;  //商品数量(int)
	 cuspeople;//消费人
	 cusplace; //消费地点
	 paykind;//付款方式
	bussiness;//商家
	 cuskind;//消费种类
	custime;//消费时间
	remark;//备注
 */
@WebServlet("/JizhangServlet")
public class JizhangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JizhangService js=new JizhangService();
		request.setCharacterEncoding("utf-8");
	//	request.getContentType().getBytes("text/html;charset=utf-8");
		String uname=(String) request.getSession().getAttribute("uname");
		System.out.println("记账界面获取session中的用户名："+uname);
		String price1=request.getParameter("price");
		Float price=Float.parseFloat(price1);
		String number1=request.getParameter("number");
		int number=Integer.parseInt(number1);
		String cuspeople=request.getParameter("cuspeople");
		String cusplace=request.getParameter("cusplace");
		String paykind=request.getParameter("paykind");
		String bussiness=request.getParameter("bussiness");
		String cuskind=request.getParameter("cuskind");
		System.out.println(cuskind);
		String remark=request.getParameter("remark");
		String custime=request.getParameter("custime");
		try {
			Jizhang jizhang=js.jz(price, number, cuspeople, cusplace, paykind, bussiness, cuskind, custime, remark, uname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("JZsuccess.html"); 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

