//problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/prime-numbers-again/

import java.io.*;
import java.util.*;
 
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),N=10000;
        int i,j,p[]=new int[N+1];
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=i;j<=N;j+=i) p[j]=i;
 
        ArrayList<Integer> f=new ArrayList<>();
        for(i=2;i<=N;i++)
        if(p[i]==i) f.add(i);
        f.add(4); f.add(27); f.add(3125);
 
        int dp[]=new int[N+1];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;
        for(int x:f)
        for(i=x;i<=N;i++)
        dp[i]=Math.min(dp[i],dp[i-x]+1);
 
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb);
    }
}
