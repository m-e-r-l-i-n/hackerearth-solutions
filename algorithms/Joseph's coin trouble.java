problem link-https://www.hackerearth.com/problem/algorithm/josephs-coin-trouble/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        String s[]=bu.readLine().split(" ");
        int k=s.length,c[]=new int[k],i,j;
        for(i=0;i<k;i++)
        c[i]=Integer.parseInt(s[i]);

        long w[]=new long[n+1]; //coin change problem
        w[0]=1;
        for(i=0;i<k;i++)
        for(j=c[i];j<=n;j++)
        w[j]+=w[j-c[i]];
        System.out.print(w[n]);
    }
}
