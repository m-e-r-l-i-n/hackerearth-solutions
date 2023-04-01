//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/vaccine-2c845ac0/

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        ArrayList<Integer> g[]=new ArrayList[n];
        long dp[]=new long[n],M=(long)1e18;

        int i;
        for(i=0;i<n;i++)
        {
            g[i]=new ArrayList<>();
            dp[i]=M;
        }
        for(i=0;i<m;i++)
        {
            s=bu.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1,v=Integer.parseInt(s[1])-1;
            g[u].add(v); g[v].add(u);
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }});
        for(i=0;i<n;i++)
        if(prime(i+1))
        {
            dp[i]=0;
            pq.add(new long[]{dp[i],i});
        }

        while(!pq.isEmpty())
        {
            long e[]=pq.poll();
            i=(int)e[1];
            if(dp[i]<e[0]) continue;

            for(int x:g[i])
            {
                int v=Math.max(x,i)+1;
                if(dp[x]>dp[i]+v)
                {
                    dp[x]=dp[i]+v;
                    pq.add(new long[]{dp[x],x});
                }
            }
        }

        for(i=0;i<n;i++)
        {
            if(dp[i]==M) dp[i]=-1;
            sb.append(dp[i]+" ");
        }
        System.out.println(sb);
    }

    static boolean prime(int n)
    {
        if(n==1) return false;
        for(int i=2;i*i<=n;i++)
        if(n%i==0) return false;
        return true;
    }
}
