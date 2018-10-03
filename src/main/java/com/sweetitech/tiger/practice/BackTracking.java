package com.sweetitech.tiger.practice;

public class BackTracking {

    public static void main(String[] args)
    {
        String str= "ABCD";
        int n = str.length();
        BackTracking backTracking = new BackTracking();
        backTracking.permute(str,0,n-1);
    }

    public void permute(String s,int l, int r)
    {
        if(l==r)
        {
            System.out.println(s);

        }
        else
        {
            for(int i=l;i<=r;i++)
            {
                s = swap(s,l,i);
                permute(s,l+1,r);
                s = swap(s,l,i);
            }
        }
    }

    public String swap(String s, int i, int j)
    {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
        return String.valueOf(arr);
    }
}
