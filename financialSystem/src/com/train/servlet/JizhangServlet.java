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
 * �������ϵͳ����ģ��servlet
 * ������ǰ��ҳ���ϴ���ļ�����Ϣ������������Ϣ
 * price;  //��Ʒ���ۣ�float��
	 number;  //��Ʒ����(int)
	 cuspeople;//������
	 cusplace; //���ѵص�
	 paykind;//���ʽ
	bussiness;//�̼�
	 cuskind;//��������
	custime;//����ʱ��
	remark;//��ע
 */
@WebServlet("/JizhangServlet")
public class JizhangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JizhangService js=new JizhangService();
		request.setCharacterEncoding("utf-8");
	//	request.getContentType().getBytes("text/html;charset=utf-8");
		String uname=(String) request.getSession().getAttribute("uname");
		System.out.println("���˽����ȡsession�е��û�����"+uname);
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

