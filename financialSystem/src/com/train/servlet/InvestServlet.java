package com.train.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/InvestServlet")
public class InvestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//request.getContentType().getBytes("text/html;charset=utf-8");
		float gain = 0 ;
		float total=0;
		
		
		String uname=(String) request.getSession().getAttribute("uname");
		System.out.println("��Ϣ�����л�ȡ���û�����"+uname);
		String _invest=request.getParameter("invest");
		float invest=Float.parseFloat(_invest);
		System.out.println(invest);
		String investkind=URLDecoder.decode(request.getParameter("investkind"),"utf-8");

		System.out.println(investkind);
		String _investtime=request.getParameter("investtime");
		
		int investtime=Integer.parseInt(_investtime);
		System.out.println(investtime);
		try{
		if(investkind.equals("���л���")){
			gain=(float) (invest*0.0035/12*investtime);//���л��ڴ����Ϣ=��������ʡ�����;���ڴ�����ϢΪ0.3%����
			System.out.println(gain);
			total=invest+gain;//��Ϣ�ϼ�
			System.out.println(total);
			
		}else if(investkind.equals("��")){
			//���ļ�Ϣ��ʽ��ÿ��ʵ������=��������桿*(����ȷ�Ͻ�/10000)(����˾ÿ�춼�ṫ����������桿)
			//��2018��3��28��Ϊ�����������Ϊ1.1229
			
			gain=(float) ((invest*1.1229)/10000)*30*investtime;
			total=invest+gain;
			
		}else if(investkind.equals("����С���")){
			//����С���ļ��㣺�� ����С����ڵķݶ� / 10000 ���� �������˾������ÿ������棨ÿ�������Ϊ����ֵ��ÿ���ڻ���˾���й�����
			//ע�⣬С�����ʹ�ø��������
			//��2018��3��28��Ϊ�����������Ϊ1.0867
			
			
			int time=investtime*30;//���ݹ�����������������30����Ϊ����
			gain=(float) (time*invest/10000*1.0867);
			total=invest+gain;
			
		}else if(investkind.equals("���ж���")){
			//���ж�����Ϣ����Ϊ3���£����꣬һ�꣬���꣬���꣬����
			//���ж��ڴ���Ϣ=��������ʡ����ޣ����ڴ���ʱ�䲻ͬ������Ҳ��ͬ�����Է�Ϊ�������
			switch(investtime){
			case 3:gain=(float) (invest*0.0143/12*investtime);
				   total=invest+gain;
				   break;
			case 6:gain=(float) (invest*0.0169/12*investtime);
			      total=invest+gain;
			      break;
			case 12:gain=(float) (invest*0.0195/12*investtime);
		            total=invest+gain;
		            break;
			case 24:gain=(float) (invest*0.0273/12*investtime);
					total=invest+gain;
					break;
			case 36:gain=(float) (invest*0.033/12*investtime);
					total=invest+gain;
					break;
			case 60:gain=(float) (invest*0.033/12*investtime);
            total=invest+gain;
            break;
			}
			
		}
		
		 //�������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //�����ӳض����л�ȡ���ݿ�����
        Connection conn=dataSource.getConnection();
        String sql="insert into InvestGain (uname,invest,gain,total,investkind,investtime) values('"+uname+"','"+invest+"','"+gain+"','"+total+"','"+investkind+"','"+investtime+"')";
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(sql);
		int rs=ps.executeUpdate();
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		jsonobj.put("invest", invest);
		jsonobj.put("gain", gain);
		jsonobj.put("total", total);
		jsonobj.put("investkind", investkind);
		jsonobj.put("investtime", investtime);
		jsonarray.add(jsonobj);
		// �������
		  response.setHeader("Access-Control-Allow-Origin", "*");
	   		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		           out = response.getWriter();
		           out.println(jsonarray);
		           System.out.println(jsonarray);
		           
		   		out.flush();
		   		out.close();
				
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
