problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/roy-and-flower-farm/?layout=old

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),p=Integer.parseInt(s[1]);
            int i,j,val[]=new int[n],wt[]=new int[n];
            for(i=0;i<n;i++)
            {
                s=bu.readLine().split(" ");
                val[i]=Integer.parseInt(s[0]);
                wt[i]=Integer.parseInt(s[1]);
                val[i]=val[i]-wt[i];
            }

            //lets modify 0-1 knapsack problem
            int dp[][]=new int[n+1][p+1];
            for(i=0;i<=n;i++)
            for(j=0;j<=p;j++)
            if(i==0 || j==0) dp[i][j]=0;
            else if(wt[i-1]<=j) dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
            else dp[i][j]=dp[i-1][j];

            int cost=dp[n][p];
            int loss=0;
            for(i=p;i>=0;i--)
            if(dp[n][i]==cost) loss=i;
            cost+=p;
            sb.append(loss+" "+cost+"\n");
        }
        System.out.print(sb);
    }
}
