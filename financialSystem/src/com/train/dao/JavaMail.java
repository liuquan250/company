package com.train.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class JavaMail {
	 public static void main(String[] args) throws AddressException, MessagingException {       

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

	 message.setRecipients( RecipientType.TO,new InternetAddress[] { new InternetAddress("1731120097@qq.com") });       

		 //�����ʼ�����        

		message.setSubject("���ǵ�һ��Java�ʼ�");        

		//�����ʼ�����        

		message.setText("����Ϊ�� ���ǵ�һ��java���������ʼ���");       

		 //�õ��ʲ����        

		Transport transport = session.getTransport();        

		//�����Լ��������˻�        

		transport.connect("1731120097@qq.com", "sjwofseaunmpeceh");//����Ϊ�ղŵõ�����Ȩ��        
		//�����ʼ�

        transport.sendMessage(message, message.getAllRecipients());    

		}
}
