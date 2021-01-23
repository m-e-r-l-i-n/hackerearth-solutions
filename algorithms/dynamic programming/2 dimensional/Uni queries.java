problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/rook-path-142e55ee/?layout=old

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
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
            int a[][]=new int[n][m],i,j;
            for(i=0;i<n;i++)
            {
                String st=bu.readLine();
                for(j=0;j<m;j++)
                if(st.charAt(j)=='*') a[i][j]=1;
            }

            long dp[][]=new long[n][m],r[]=new long[n],c[]=new long[m],M=1000000007;
            dp[0][0]=1;
            r[0]=c[0]=1;
            for(i=1;i<m;i++)
            if(a[0][i]==1) break;
            else
            {
                dp[0][i]=i==1?1:dp[0][i-1]*2%M;
                c[i]+=dp[0][i];
            }

            for(i=1;i<n;i++)
            if(a[i][0]==1) break;
            else
            {
                dp[i][0]=i==1?1:dp[i-1][0]*2%M;
                r[i]+=dp[i][0];
            }

            for(i=1;i<n;i++)
            for(j=1;j<m;j++)
            if(a[i][j]==1)
            {
                dp[i][j]=0;
                c[j]=0;
                r[i]=0;
            }
            else
            {
                dp[i][j]=(r[i]+c[j])%M;
                r[i]=(r[i]+dp[i][j])%M;
                c[j]=(c[j]+dp[i][j])%M;
            }
            sb.append(dp[n-1][m-1]+"\n");
        }
        System.out.print(sb);
    }
}
