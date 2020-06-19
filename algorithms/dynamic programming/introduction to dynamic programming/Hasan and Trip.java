problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/hasan-and-trip/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,a[][]=new int[n][3];
        double max=0;
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            a[i][0]=Integer.parseInt(s[0]);
            a[i][1]=Integer.parseInt(s[1]);
            a[i][2]=Integer.parseInt(s[2]);
            max+=a[i][2];
            if(i>0)
            max-=Math.sqrt(Math.pow(a[i][0]-a[i-1][0],2)+Math.pow(a[i][1]-a[i-1][1],2));
        }
        int prev=0;
        for(i=1;i<n-1;i++)
        {
            double val=max-a[i][2];
            val+=Math.sqrt(Math.pow(a[i][0]-a[prev][0],2)+Math.pow(a[i][1]-a[prev][1],2));
            val+=Math.sqrt(Math.pow(a[i+1][0]-a[i][0],2)+Math.pow(a[i+1][1]-a[i][1],2));
            val-=Math.sqrt(Math.pow(a[i+1][0]-a[prev][0],2)+Math.pow(a[i+1][1]-a[prev][1],2));
            if(val>max) max=val;
            else prev=i;
        }
        System.out.format("%.6f",max);
    }
}
