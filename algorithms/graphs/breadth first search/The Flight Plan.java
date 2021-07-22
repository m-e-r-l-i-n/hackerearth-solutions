//problem link-https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/traffic-light-2-ee27ba45/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),t=Integer.parseInt(s[2]),c=Integer.parseInt(s[3]);
        ArrayList<Integer> g[]=new ArrayList[n],p[]=new ArrayList[n];
        int i,d[]=new int[n];
        for(i=0;i<n;i++)
        {
            g[i]=new ArrayList<>();
            p[i]=new ArrayList<>();
            d[i]=-1;
        }

        for(i=0;i<m;i++)
        {
            s=bu.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1,v=Integer.parseInt(s[1])-1;
            g[u].add(v); g[v].add(u);
        }
        s=bu.readLine().split(" ");
        int sr=Integer.parseInt(s[0])-1,de=Integer.parseInt(s[1])-1;

        Queue<Integer> q=new LinkedList<>();
        d[sr]=0; q.add(sr); p[sr].add(sr);
        while(!q.isEmpty())
        {
            i=q.poll();
            for(int x:g[i])
            if(d[x]==-1)
            {
                d[x]=d[i]+1;
                for(int y:p[i]) p[x].add(y);
                p[x].add(x);
                q.add(x);
            }
            else if(d[x]==d[i]-1) minima(p[i],p[x],i);
        }

        sb.append(p[de].size()+"\n");
        for(int x:p[de]) sb.append(x+1+" ");
        System.out.println(sb);
    }

    static void minima(ArrayList<Integer> a,ArrayList<Integer> b,int v)
    {
        int n=b.size(),i;
        for(i=0;i<n;i++)
        if(a.get(i)<b.get(i)) return;
        else if(a.get(i)>b.get(i))
        {
            while(i<n) a.set(i,b.get(i++));
            return;
        }
    }
}
