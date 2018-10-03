package com.sweetitech.tiger.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeFormatter {

    public static String gmtTimeformatter(String datetime)
    {

        SimpleDateFormat sdfgmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfgmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        SimpleDateFormat sdfmad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfmad.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));


        String inpt= datetime;
        Date inptdate = null;
        try {
            inptdate = sdfgmt.parse(inpt);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        String time = null;
        String[] arr = sdfmad.format(inptdate).toString().split(" ");

            try{
                SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
                Date dateObj = sdf.parse(arr[1]);
                time= new SimpleDateFormat("K:mm:ss a").format(dateObj).toString();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        return arr[0]+", "+time;
    }
}
