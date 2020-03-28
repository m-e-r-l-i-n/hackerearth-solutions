problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/minimum-and-xor-or-6a05bbd4/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int a[]=new int[n],i,j,min=1000000000;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            Arrays.sort(a);

            /*what do we have to do here-
            let us denote the a[i]=a, a[j]=b i !=j
            (a&b)^(a|b)
            =(a&b)&(a|b)-(a&b)|(a|b)
            =(a&b)-(a|b)
            =a^b
            thus we have to find minimum xor of 2 numbers
            the fastest way to find it is to check xor of consecutive numbers in a sorted array*/

            for(i=1;i<n;i++)
            if((a[i]^a[i-1])<min) min=a[i]^a[i-1];
            if(n==1) min=0;
            sb.append(min+"\n");
        }
        
        System.out.print(sb);
    }
}
