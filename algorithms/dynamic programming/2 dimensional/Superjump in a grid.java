//problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/superjump-in-a-grid-773f1e31/

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

        int i,j,l[][]=new int[n][m],u[][]=new int[n][m]; long dp[][]=new long[n][m],M=1000000007;
        boolean g[][]=new boolean[n][m];
        for(i=0;i<n;i++)
        {
            String st=bu.readLine();
            for(j=0;j<m;j++) g[i][j]=st.charAt(j)=='0';
        }

        for(i=0;i<Math.max(n,m);i++)
        {
            if(i<n)
            {
                int p=-1;
                for(j=0;j<m;j++)
                {
                    l[i][j]=p;
                    if(g[i][j]) p=j;
                }
            }

            if(i<m)
            {
                int p=-1;
                for(j=0;j<n;j++)
                {
                    u[j][i]=p;
                    if(g[j][i]) p=j;
                }
            }
        }

        dp[0][0]=g[0][0]?1:0;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(i+j!=0 && g[i][j])
        {
            if(l[i][j]!=-1) dp[i][j]+=dp[i][l[i][j]];
            if(u[i][j]!=-1) dp[i][j]+=dp[u[i][j]][j];
            dp[i][j]%=M;
        }
        System.out.println(dp[n-1][m-1]);
    }
}
