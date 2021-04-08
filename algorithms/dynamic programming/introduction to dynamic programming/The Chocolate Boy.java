//problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/the-chocolate-boy-738c799b/

import java.io.*;
import java.util.*;
 
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        int dp[][][]=new int[2][m+1][2],i,j,cur=1;
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            if(s[1].equals("H")) continue;
            int p=Integer.parseInt(s[3]),x=Integer.parseInt(s[2]);
            for(j=0;j<=m;j++)
            if(j<x/2) dp[cur][j][1]=dp[cur^1][j][1];
            else dp[cur][j][1]=Math.max(dp[cur^1][j][1],dp[cur^1][j-x/2][0]+p);
            for(j=0;j<=m;j++)
            if(j<x) dp[cur][j][0]=dp[cur^1][j][0];
            else
            {
                dp[cur][j][1]=Math.max(dp[cur][j][1],Math.max(dp[cur^1][j][1],dp[cur^1][j-x][1]+p));
                dp[cur][j][0]=Math.max(dp[cur^1][j][0],dp[cur^1][j-x][0]+p);
            }
            cur^=1;
        }
        int ans=0;
        for(i=0;i<=m;i++)
        {
            ans=Math.max(dp[cur^1][i][0],ans);
            ans=Math.max(dp[cur^1][i][1],ans);
        }
        System.out.println(ans);
    }
}
