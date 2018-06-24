package com.train.servlet;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class try1 {
	 public static String addDay(String s, int n) {   

	        try {   

	             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   

	  

	             Calendar cd = Calendar.getInstance();   

	             cd.setTime(sdf.parse(s));   

	             cd.add(Calendar.DATE, n);//增加一天   

	            //cd.add(Calendar.MONTH, n);//增加一个月   

	  

	            return sdf.format(cd.getTime());   

	  

	         } catch (Exception e) {   

	            return null;   

	         }   
	
	 }	
}
