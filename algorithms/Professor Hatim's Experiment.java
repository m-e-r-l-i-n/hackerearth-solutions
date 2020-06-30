problem link-https://www.hackerearth.com/problem/algorithm/professor-hatims-experiment/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        for(int v=1;v<=t;v++)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),i,m=Integer.parseInt(s[1]),a[][]=new int[m][2];
            for(i=0;i<m;i++)
            {
                s=bu.readLine().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
                if(a[i][0]>a[i][1]) a[i][0]=a[i][0]^a[i][1]^(a[i][1]=a[i][0]);
            }
            boolean ans=bipartition(n,a);
            if(ans) sb.append("No suspicious lizards found!\n");
            else sb.append("Suspicious lizards found!\n");
        }
        System.out.print(sb);
    }

    public static boolean bipartition(int n, int[][] dis)
    {
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[n+1],i,j;
        Arrays.fill(vis,-1);
        for(i=1;i<=n;i++)
        if(vis[i]==-1)
        {
            vis[i]=0;
            q.add(i);
            while(!q.isEmpty())
            {
                int u=q.poll();
                for(j=0;j<dis.length;j++)
                if(dis[j][0]==u || dis[j][1]==u)
                {
                     int v=(dis[j][0]==u?dis[j][1]:dis[j][0]);
                     if(vis[v]==-1)
                     {vis[v]=(vis[u]==0?1:0);
                     q.add(v);}
                     else if(vis[v]==vis[u]) return false;
                }
            }
        }
        return true;
    }
}
