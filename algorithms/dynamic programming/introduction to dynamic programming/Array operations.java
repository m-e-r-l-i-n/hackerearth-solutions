problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/array-operations-3-96b9f0e0/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int i,a[]=new int[n];
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            if(n==1) {sb.append(Math.max(0,a[0])+"\n"); continue;}

            long l[]=new long[n],r[]=new long[n+2],ans=0;
            l[0]=a[0];
            ans=Math.max(ans,a[0]);
            for(i=1;i<n;i++)
            {
                l[i]=Math.max(a[i],l[i-1]+a[i]);
                ans=Math.max(ans,l[i]);
            }
            r[n-1]=a[n-1];
            for(i=n-2;i>=0;i--) r[i]=Math.max(a[i],r[i+1]+a[i]);

            for(i=n-2;i>=0;i--)
            {
                r[i]=Math.max(r[i],r[i+1]);
                ans=Math.max(ans,l[i]+r[i+2]);
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
