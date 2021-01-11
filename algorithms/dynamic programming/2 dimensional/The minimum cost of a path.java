problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/minimum-cost-path-in-a-grid-2-2e1df6ef/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,j,N=100000,p[]=new int[N+1];
        for(i=1;i<=N;i++) p[i]=i;

        for(i=2;i<=N;i++)
        if(p[i]==i)
        for(j=2*i;j<=N;j+=i)
        p[j]=i;

        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
            int g[][]=new int[n][m];
            for(i=0;i<n;i++)
            {
                s=bu.readLine().split(" ");
                for(j=0;j<m;j++)
                {
                    int x=Integer.parseInt(s[j]);
                    int c=0,d;
                    while(x>1)
                    {
                        d=p[x];
                        while(x%d==0)
                        {
                            x/=d;
                            c++;
                        }
                    }
                    g[i][j]=c;
                }
            }

            long dp[][]=new long[n][m];
            dp[0][0]=g[0][0];
            for(i=1;i<m;i++)
            dp[0][i]=dp[0][i-1]+g[0][i];
            for(i=1;i<n;i++)
            dp[i][0]=dp[i-1][0]+g[i][0];

            for(i=1;i<n;i++)
            for(j=1;j<m;j++)
            dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+g[i][j];
            sb.append(dp[n-1][m-1]+"\n");
        }
        System.out.print(sb);
    }
}
