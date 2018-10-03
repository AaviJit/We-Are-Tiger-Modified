package com.sweetitech.tiger.practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class timeFormatter {
    public static void main(String[] args)
    {
        SimpleDateFormat sdfgmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfgmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        SimpleDateFormat sdfmad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfmad.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));

        String inpt = "2011-23-03 13:30:00";
        Date inptdate = null;
        try {
            inptdate = sdfgmt.parse(inpt);
        } catch (Exception e) {e.printStackTrace();}

        System.out.println("GMT:\t\t" + sdfgmt.format(inptdate));

        System.out.println("Asia/Dhaka:\t" + sdfmad.format(inptdate));
        String[]  arr = sdfmad.format(inptdate).toString().split(" ");
        System.out.println(arr[0]+" and "+ arr[1]);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
            Date dateObj = sdf.parse(arr[1]);
            String time= new SimpleDateFormat("K:mm:ss a").format(dateObj).toString();
            System.out.println("After Formatting to AM/PM : "+ time);
        }
        catch (Exception e)
        {

        }
    }
}
