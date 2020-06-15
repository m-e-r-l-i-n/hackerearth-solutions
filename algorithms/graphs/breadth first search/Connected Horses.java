problem link-https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/connected-horses-10/

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        long fac[]=new long[1000001],M=1000000007;
        fac[0]=fac[1]=1;
        for(int v=2;v<=1000000;v++)
        fac[v]=(fac[v-1]*v)%M;    
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),q=Integer.parseInt(s[2]);
            int g[][]=new int[n][m],i;
            Point h[]=new Point[q];
            boolean vis[][]=new boolean[n][m];
            long ans=1;
            for(i=0;i<q;i++)
            {
                s=bu.readLine().split(" ");
                h[i]=new Point(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1);
                g[h[i].x][h[i].y]=i+1;
            }

            for(i=0;i<q;i++)
            {
                if(!vis[h[i].x][h[i].y])
                {
                    c=0;
                    dfs(g,vis,h[i]);
                    ans=(ans*fac[c])%M;
                }
            }
            //System.out.println();
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int c=0;
    static void dfs(int g[][],boolean vis[][],Point n)
    {
        vis[n.x][n.y]=true; c++;
        int m[]={-2,2},m2[]={-1,1},i,j;
        Queue<Point> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            Point p=q.poll();
            for(i=0;i<2;i++)
            for(j=0;j<2;j++)
            if(valid(p.x-m[i],p.y-m2[j],g) && g[p.x-m[i]][p.y-m2[j]]!=0 && !vis[p.x-m[i]][p.y-m2[j]])
            {
                c++;
                q.add(new Point(p.x-m[i],p.y-m2[j]));
                vis[p.x-m[i]][p.y-m2[j]]=true;
            }
            for(i=0;i<2;i++)
            for(j=0;j<2;j++)
            if(valid(p.x-m2[i],p.y-m[j],g) && g[p.x-m2[i]][p.y-m[j]]!=0 && !vis[p.x-m2[i]][p.y-m[j]])
            {
                c++;
                q.add(new Point(p.x-m2[i],p.y-m[j]));
                vis[p.x-m2[i]][p.y-m[j]]=true;
            }
        }
    }

    static boolean valid(int r,int c,int g[][])
    {
        if(r>=0 && r<g.length && c>=0 && c<g[0].length) return true;
        else return false;
    }

    static class Point
    {
        int x,y;
        Point(int a,int b)
        {
            x=a; y=b;
        }
    }

    static long pow(long a,long b,long M)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=(res*a)%M;
            a=(a*a)%M;
            b>>=1;
        }
        return res;
    }
}
