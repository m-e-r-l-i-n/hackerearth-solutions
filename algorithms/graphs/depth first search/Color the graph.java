problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/color-the-graph/?layout=old

import java.io.*;
import java.util.*;
 
class TestClass
{
    static int flag,cnt,tot;
    static boolean vis[];
    static int c[];
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer("");
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            st=new StringTokenizer(bu.readLine());
            int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),i,ans=0;
            ArrayList<Integer> g[]=new ArrayList[n+1];
            for(i=0;i<=n;i++)
                g[i]=new ArrayList<>();
            for(i=0;i<m;i++)
            {
                st=new StringTokenizer(bu.readLine());
                int l=Integer.parseInt(st.nextToken()),r=Integer.parseInt(st.nextToken());
                g[l].add(r);
                g[r].add(l);
            }
            vis=new boolean[n+1];
            c=new int[n+1];
            int j,f=0,all=0;
            for(i=1;i<=n;i++)
            if(!vis[i])
            {
                flag=0; cnt=0; tot=0;
                dfs(g,i);
                if(flag==1) {f++; break;}
                ans+=Math.max(cnt,tot-cnt);
                all+=tot;
                if(all==n) break;
            }
            if(f!=0) System.out.print("NO\n");
            else System.out.print(ans+"\n");
        }
    }
 
    static void dfs(ArrayList<Integer> g[],int v)
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(v,0));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            if(vis[p.x] && c[p.x]!=p.y)
            {flag=1;return;}
            else if(vis[p.x]) continue;
            vis[p.x]=true;
            c[p.x]=p.y;
            cnt+=p.y;
            tot++;
            for(int u:g[p.x])
            q.add(new Pair(u,1-p.y));
        }
    }
 
    static class Pair
    {
        int x,y;
        Pair(int a,int b)
        {
            x=a; y=b;
        }
    }
}
