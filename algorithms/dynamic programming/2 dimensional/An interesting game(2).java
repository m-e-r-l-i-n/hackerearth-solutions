problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/interesting-game-hard-93f267d9/

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
            HashMap<Long,Integer> hm=new HashMap<>();
            int i; long a;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a=Long.parseLong(s[i]);
                hm.put(a,hm.getOrDefault(a,0)+1);
            }
            n=hm.size();
            int x[]=new int[n],m=0; i=0;
            for(int z:hm.values())
            {
                x[i++]=z;
                m=Math.max(m,z);
            }

            m=(1<<(int)(Math.log(m)/Math.log(2)+1))-1;
            long dp[][]=new long[2][m+1],M=1000000007;
            dp[0][0]=1; int j,prev=0,cur=1;
            for(i=1;i<=n;i++)
            {
                for(j=0;j<=m;j++)
                dp[cur][j]=(dp[prev][j]+dp[prev][j^x[i-1]])%M;
                cur^=1;
                prev^=1;
            }
            sb.append(dp[prev][0]+"\n");
        }
        System.out.print(sb);
    }
}
