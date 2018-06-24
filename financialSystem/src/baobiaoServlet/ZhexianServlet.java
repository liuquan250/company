package baobiaoServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.train.servlet.try1;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/ZhexianServlet")
public class ZhexianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname=(String) request.getSession().getAttribute("uname");
		System.out.println("折线统计图中获取的用户名"+uname);
		 String startDate = request.getParameter("startDate");
		 System.out.println("-------------"+startDate);
		String endDate=request.getParameter("endDate");
		System.out.println("----------"+endDate);
		try{
		//创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //从连接池对象中获取数据库连接
        Connection conn=dataSource.getConnection();
        
        
		int _days=Countdays.longOfTwoDate(startDate, endDate);
		System.out.println(_days);
		int days=_days+1;
		System.out.println("时间段内天数："+days);
		
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	    String date;
	    date=sdf.format(sdf.parse(startDate));
		System.out.println(date);
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		
		for(int i=0;i<days;i++){
			String tate=try1.addDay(date, i);
			
			String sql="select SUM(totalprice) as n,custime from [financialSystem].[dbo].[CusInfo]  where custime ='"+tate+"' and uname='"+uname+"' group by custime  ";
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				jsonobj.put("n", rs.getString("n"));
				jsonobj.put("custime", rs.getString("custime").substring(0, 10));
				jsonarray.add(jsonobj); 
		}
		
		}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
