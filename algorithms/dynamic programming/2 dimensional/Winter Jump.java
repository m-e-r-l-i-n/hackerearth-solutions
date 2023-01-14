//problem link- https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/winterjump-31a147d9/

import java.io.*;
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        
        int dp[][]=new int[n][n],a[]=new int[n],i,j,M=(int)1e9;
        s=bu.readLine().split(" ");
        a[0]=Integer.parseInt(s[0]);
        for(i=1;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            for(j=0;j<n;j++) dp[i][j]=M;

            for(j=i-1;j>=Math.max(i-k,0);j--)
            {
                int d=Math.abs(a[i]-a[j]);
                dp[i][d]=Math.min(dp[i][d],dp[j][d]+1);
            }

            for(j=n-2;j>=0;j--) dp[i][j]=Math.min(dp[i][j],dp[i][j+1]);
        }

        int ans=M;
        for(i=0;i<n;i++) ans=Math.min(ans,dp[n-1][i]);
        if(ans==M) ans=-1;
        System.out.println(ans);
    }
}
