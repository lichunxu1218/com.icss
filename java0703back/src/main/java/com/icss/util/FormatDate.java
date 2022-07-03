package com.icss.util;

import java.util.Calendar;
import java.util.Date;

public class FormatDate {
    public static String dateToString(Date date){
        Calendar c =Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int m =c.get(Calendar.MONDAY)+1;
        int d = c.get(Calendar.DATE);
        String sm= m<10? "0"+m:""+m;
        String sd= d<10? "0"+d:""+d;
        return year+"-"+sm+"-"+sd;
    }
}
