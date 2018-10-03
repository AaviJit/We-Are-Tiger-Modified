package com.sweetitech.tiger.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice {

    public static void main (String[] args)
    {
        int num=5;
        int res=0;

        String name = "1,2,1,w,0,1,1,3,2,3";
        List<String> list = Arrays.asList(name.split(","));
        for(int i=0;i<list.size();i++)
        {System.out.println(list.get(i));}

        student a1 = new student(1,"avijit","1201010m","01812");
        student a2 = new student(2,"shuva","1201011m","018120");
        student a3 = new student(3,"mumu","1201012f","0181202");
        List<student> list1 = new ArrayList<>();
        list1.add(a1);
        list1.add(a2);
        list1.add(a3);

        student b1 = new student(1,"avijit","1201010m","01812");
        student b2 = new student(2,"shuva","1201011m","018120");
        student b3 = new student(3,"mumu","1201012f","0181202");
        List<student> list2 = new ArrayList<>();
        list2.add(b1);
        list2.add(b2);
        list2.add(b3);

        student teamAplayer1 = list2.stream().
                filter(p -> p.getId().equals(list1.
                        get(2).getId())).findFirst().orElse(null);

        System.out.println(teamAplayer1);




        String thisString="192/10";
        String[] parts = thisString.split("/");
        String first = parts[0];
        int score = Integer.parseInt(first);
        System.out.println(score);
        String second = parts[1];
        System.out.println(second);
        try {

            try {


                if (num > 2) {
                    System.out.println("bigger than 2");
                }
                if (num > 3) {
                    System.out.println("bigger than 3");
                }
                if (num > 4) {
                    System.out.println("bigger than 4");
                }

                res = num / 0;

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println("No problem here");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Done Successfully");
        }
        catch (Exception e)
        {
            System.out.println("Done Successfully");
        }
    }
}
