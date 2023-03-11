//problem link-https://www.hackerearth.com/problem/algorithm/alice-and-trees-76904ccd/

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        ArrayList<Integer> g[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(i=0;i<n-1;i++)
        {
            String s[]=bu.readLine().split(" ");
            int u=Integer.parseInt(s[0]),v=Integer.parseInt(s[1]);
            g[u].add(v); g[v].add(u);
        }

        int dp[][]=new int[n][n+1];
        dfs(g,0,-1,dp);
        for(i=1;i<=n;i++)
        {
            int j,min=(int)1e9;
            for(j=0;j<n;j++) min=Math.min(min,dp[j][i]);
            sb.append(min+" ");
        }
        System.out.println(sb);
    }


    static int dfs(ArrayList<Integer> g[],int n,int p,int dp[][])
    {
        int M=(int)1e9,below=1,prev[]=new int[g.length+1];
        Arrays.fill(dp[n],M);    //nth node is attached to smth
        dp[n][1]=g[n].size();

        for(int x:g[n])
        if(x!=p)
        {
            int child=dfs(g,x,n,dp);
            below+=child;

            int i,j;
            for(i=0;i<=below;i++) prev[i]=dp[n][i];
            for(i=1;i<=child;i++)
            {
                for(j=below;j-i>=1;j--)
                dp[n][j]=Math.min(dp[n][j],dp[x][i]+prev[j-i]-2);
            }
        }

        //System.out.println("\n"+n);
        //for(int i=1;i<=below;i++) System.out.print(dp[n][i]+" ");
        return below;
    }
}
