package baobiaoServlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Countdays {
    
    
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public static int longOfTwoDate(String start,String end) throws Exception{
 
        Date firstdate = format.parse(start);
        Date seconddate = format.parse(end);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstdate);
        int cnt = 0;
        while(calendar.getTime().compareTo(seconddate)!=0){
            calendar.add(Calendar.DATE, 1);
            cnt++;
        }
        return cnt;
    }
    
   
}