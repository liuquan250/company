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
		System.out.println("利息计算中获取的用户名："+uname);
		String _invest=request.getParameter("invest");
		float invest=Float.parseFloat(_invest);
		System.out.println(invest);
		String investkind=URLDecoder.decode(request.getParameter("investkind"),"utf-8");

		System.out.println(investkind);
		String _investtime=request.getParameter("investtime");
		
		int investtime=Integer.parseInt(_investtime);
		System.out.println(investtime);
		try{
		if(investkind.equals("银行活期")){
			gain=(float) (invest*0.0035/12*investtime);//银行活期存款利息=本金×利率×期限;定期存款的利息为0.3%左右
			System.out.println(gain);
			total=invest+gain;//本息合计
			System.out.println(total);
			
		}else if(investkind.equals("余额宝")){
			//余额宝的计息公式：每天实际收益=【万分收益】*(【余额宝确认金额】/10000)(基金公司每天都会公布【万分收益】)
			//以2018年3月28号为例，万分收益为1.1229
			
			gain=(float) ((invest*1.1229)/10000)*30*investtime;
			total=invest+gain;
			
		}else if(investkind.equals("京东小金库")){
			//京东小金库的计算：（ 京东小金库内的份额 / 10000 ）× 当天基金公司公布的每万份收益（每万份收益为波动值，每日在基金公司进行公布）
			//注意，小金库是使用复利计算的
			//以2018年3月28号为例，万分收益为1.0867
			
			
			int time=investtime*30;//传递过来的是月数，乘以30，成为天数
			gain=(float) (time*invest/10000*1.0867);
			total=invest+gain;
			
		}else if(investkind.equals("银行定期")){
			//银行定期利息，分为3个月，半年，一年，二年，三年，五年
			//银行定期存款：利息=本金×利率×期限，由于存款的时间不同，利率也不同，所以分为数种情况
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
		
		 //创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //从连接池对象中获取数据库连接
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
		// 输出数据
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
