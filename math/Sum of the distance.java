problem link-https://www.hackerearth.com/problem/algorithm/sum-of-distances-8944e591/

import java.io.*;
import java.math.*;
import java.util.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int a[]=new int[n],i,j;
        String s[]=bu.readLine().split(" ");
        double sum=0;
        for(i=0;i<n;i++)
        {a[i]=Integer.parseInt(s[i]);
        sum+=Math.sin(a[i])*Math.cos(a[i]);}
        sum=(n-1)*sum;
        System.out.format("%.2f",sum);
    }
}
