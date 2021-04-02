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
        int i,c[]=new int[n];
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();

        for(i=0;i<m;i++)
        {
            s=bu.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1,v=Integer.parseInt(s[1])-1;
            g[u].add(v); g[v].add(u);
            c[u]++; c[v]++;
        }

        boolean vis[]=new boolean[n]; int ans=0,cur;
        for(i=0;i<n;i++)
        if(!vis[i])
        {
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            cur=c[i];
            vis[i]=true;

            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int x:g[p])
                if(!vis[x])
                {
                    vis[x]=true;
                    q.add(x);
                    cur+=c[x];
                }
            }
            ans=Math.max(ans,cur/2);
        }
        System.out.println(ans);
    }
}
