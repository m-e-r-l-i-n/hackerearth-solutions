problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/weird-sum-1d2a0a2e/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),m=Integer.parseInt(s[2]);
        long dp[][]=new long[n][k];
        s=bu.readLine().split(" ");
        int i,j,a[]=new int[n];
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        ArrayList<Pair> al=new ArrayList<>();
        for(i=0;i<k;i++)
        al.add(new Pair(i,n-k+i));

        for(i=al.get(0).l;i<=al.get(0).r;i++)
        dp[i][0]=a[i];
        for(i=1;i<k;i++)
        {
            long max=dp[i-1][i-1];
            for(j=al.get(i).l;j<=al.get(i).r;j++)
            {
                max=Math.max(max,dp[j-1][i-1]);
                dp[j][i]=max;
            }
            for(j=al.get(i).l;j<=al.get(i).r;j++)
            dp[j][i]+=1l*a[j]*((i+1)%m);
        }
        long ans=Long.MIN_VALUE;
        for(i=al.get(al.size()-1).l;i<=al.get(al.size()-1).r;i++)
        ans=Math.max(ans,dp[i][k-1]);
        System.out.print(ans);
    }

    static class Pair
    {
        int l,r;
        Pair(int a,int b)
        {
            l=a; r=b;
        }
    }
}
