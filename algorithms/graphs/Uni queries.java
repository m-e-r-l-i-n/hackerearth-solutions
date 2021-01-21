problem link-https://www.hackerearth.com/problem/algorithm/uni-query-1083372b/?layout=old

import java.io.*;
import java.util.*;
 
public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
            int i;
            g=new ArrayList[n];
            for(i=0;i<n;i++)
            {
                g[i]=new ArrayList<>();
                par[i]=i;
                add[i]=a[i]=0;
            }
 
            while(q-->0)
            {
                s=bu.readLine().split(" ");
                int ty=Integer.parseInt(s[0]);
                if(ty==1)
                {
                    int x=Integer.parseInt(s[1])-1,y=Integer.parseInt(s[2])-1;
                    x=par[x]; y=par[y];
                    if(x==y) continue;
                    if(g[x].size()>g[y].size()) join(x,y);
                    else join(y,x);
                }
                else if(ty==2)
                {
                    int x=Integer.parseInt(s[1])-1,v=Integer.parseInt(s[2]);
                    x=par[x];
                    add[x]+=v;
                }
                else
                {
                    int x=Integer.parseInt(s[1])-1;
                    sb.append(a[x]+add[par[x]]+"\n");
                }
            }
        }
        System.out.print(sb);
    }
    static int N=500000,par[]=new int[N];
    static long add[]=new long[N],a[]=new long[N];
    static ArrayList<Integer> g[];
 
    static void join(int x,int y)
    {
        a[y]+=add[y];
        a[y]-=add[x];
        g[x].add(y);
        par[y]=x;
        for(int z:g[y])
        {
            g[x].add(z);
            par[z]=x;
            a[z]+=add[y];
            a[z]-=add[x];
        }
    }
}
