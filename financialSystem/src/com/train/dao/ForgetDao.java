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
		//�������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //�����ӳض����л�ȡ���ݿ�����
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

			  properties.put("mail.transport.protocol", "smtp");// ����Э��        

			  properties.put("mail.smtp.host", "smtp.qq.com");// ������        

			  properties.put("mail.smtp.port", 465);// �˿ں�        

			  properties.put("mail.smtp.auth", "true");        

			  properties.put("mail.smtp.ssl.enable", "true");//�����Ƿ�ʹ��ssl��ȫ����  ---һ�㶼ʹ��        

			  properties.put("mail.debug", "true");//�����Ƿ���ʾdebug��Ϣ  true ���ڿ���̨��ʾ�����Ϣ        

			//�õ��ػ�����        

			Session session = Session.getInstance(properties);        

			// ��ȡ�ʼ�����        

			Message message = new MimeMessage(session);        

			//���÷����������ַ       

			 message.setFrom(new InternetAddress("1731120097@qq.com"));  
			 
			//�����ռ��˵�ַ  

		  message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(_email) });     
		  	System.out.println(_email);
			 //�����ʼ�����        

			message.setSubject("���ϵͳ-�����һ�");        

			//�����ʼ�����        

			message.setText("�����û�����"+_uname+ "      "+ "�������룺"+_password);       

			 //�õ��ʲ����        

			Transport transport = session.getTransport();        

			//�����Լ��������˻�        

			transport.connect("1731120097@qq.com", "sjwofseaunmpeceh");//����Ϊ�ղŵõ�����Ȩ��        
           
			//�����ʼ�
	       transport.sendMessage(message, message.getAllRecipients());
		return forg;
		
		   

			}
		
	}
	  

