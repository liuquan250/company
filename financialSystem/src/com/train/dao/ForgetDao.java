package com.train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.bean.Forget;

public class ForgetDao {
	public Forget forget(String uname,String email,String phonenumber) throws AddressException, MessagingException, SQLException{
		Forget forg=new Forget();      
		String _uname=null;
		      String _password=null;
		      String _email = null;
		//创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //从连接池对象中获取数据库连接
        Connection conn=dataSource.getConnection();
		
		String sql="select uname,password,email,phonenumber from UserInfo where uname='"+uname+"' and  email='"+email+"' and phonenumber='"+phonenumber+"' ";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			_uname=rs.getString("uname");
			forg.setUname(_uname);
			System.out.println(_uname);
			_password=rs.getString("password");
			System.out.println(_password);
			_email=rs.getString("email");
			forg.setEmail(_email);
			System.out.println(_email);
			String phonenumbe=rs.getString("phonenumber");
			forg.setPhonenumber(phonenumbe);
		}
		
			  Properties properties = new Properties();

			  properties.put("mail.transport.protocol", "smtp");// 连接协议        

			  properties.put("mail.smtp.host", "smtp.qq.com");// 主机名        

			  properties.put("mail.smtp.port", 465);// 端口号        

			  properties.put("mail.smtp.auth", "true");        

			  properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        

			  properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        

			//得到回话对象        

			Session session = Session.getInstance(properties);        

			// 获取邮件对象        

			Message message = new MimeMessage(session);        

			//设置发件人邮箱地址       

			 message.setFrom(new InternetAddress("1731120097@qq.com"));  
			 
			//设置收件人地址  

		  message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(_email) });     
		  	System.out.println(_email);
			 //设置邮件标题        

			message.setSubject("理财系统-密码找回");        

			//设置邮件内容        

			message.setText("您的用户名："+_uname+ "      "+ "您的密码："+_password);       

			 //得到邮差对象        

			Transport transport = session.getTransport();        

			//连接自己的邮箱账户        

			transport.connect("1731120097@qq.com", "sjwofseaunmpeceh");//密码为刚才得到的授权码        
           
			//发送邮件
	       transport.sendMessage(message, message.getAllRecipients());
		return forg;
		
		   

			}
		
	}
	  

