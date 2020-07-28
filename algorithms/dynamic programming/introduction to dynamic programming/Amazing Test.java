problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/amazing-test/?layout=old

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
            int n=Integer.parseInt(s[0]),x=Integer.parseInt(s[1]);
            int a[]=new int[n],i,j,sum=0;
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                sum+=a[i];
            }
            boolean dp[][]=new boolean[n+1][sum+1];
            for(i=0;i<=n;i++) dp[i][0]=true;
            for(i=1;i<=n;i++)
            for(j=1;j<=sum;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(a[i-1]<=j)
                dp[i][j]|=dp[i-1][j-a[i-1]];
            }
            int max=0;
            for(i=sum/2;i>=0;i--)
            if(dp[n][i]) {max=i; break;}
            max=Math.max(max,sum-max);
            if(max<=x) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }

}
