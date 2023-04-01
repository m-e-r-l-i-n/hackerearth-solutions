//https://www.hackerearth.com/problem/algorithm/building-tower-6ac95d5b/

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,N=100005;
        long dp[]=new long[N];
        for(i=1;i<N;i++)
        {
            dp[i]=1l*i*(i+1)/2;
            dp[i]+=dp[i-1];
        }

        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb);
    }
}
