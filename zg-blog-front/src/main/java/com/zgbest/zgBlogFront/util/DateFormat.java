package com.zgbest.zgBlogFront.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static String simpleDateFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String format = simpleDateFormat.format(date);
        return  format;
    }
}
