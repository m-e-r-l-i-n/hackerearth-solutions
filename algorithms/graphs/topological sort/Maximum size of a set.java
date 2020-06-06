problem link-https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/social-graph-1-ac58bbdf/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,max=0;
        Graph g=new Graph(n);
        ArrayList<Integer> gr[]=new ArrayList[n+1];
        for(i=0;i<=n;i++)
            gr[i]=new ArrayList<>();

        for(i=0;i<m;i++)
        {
            s=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            if(l==r || gr[l].contains(r)) continue;
            if(l==r-1 || r==l-1) gr[l].add(r);
            g.addEdge(l,r);
        }
        int f=1;
        if(n==1) f=0;
        for(i=2;i<=n;i++)
            if(!(gr[i].contains(i-1) || gr[i-1].contains(i))) break;
        if(i>n) f=0;
        if(f==0) System.out.print(n);
        else System.out.print(g.findLongestPath(n)+1);
    }

    static class Graph //check gfg find longest path in a DAG
    {

        int vertices;
        ArrayList<Integer> edge[];

        Graph(int vertices)
        {
            this.vertices=vertices;
            edge=new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++)
                edge[i]=new ArrayList<>();
        }

        void addEdge(int a,int b)
        {
            edge[a].add(b);
        }

        void dfs(int node, ArrayList<Integer> adj[], int dp[], boolean visited[])
        {
            visited[node]=true;
            for(int i=0;i<adj[node].size();i++)
            {
                if(!visited[adj[node].get(i)]) dfs(adj[node].get(i),adj,dp,visited);
                dp[node]=Math.max(dp[node],1+dp[adj[node].get(i)]);
            }
        }

        int findLongestPath(int n)
        {
            ArrayList<Integer> adj[]=edge;
            int dp[]=new int[n+1],i,ans=0;
            boolean[] visited=new boolean[n+1];

            for(i=1;i<=n;i++)
                if(!visited[i]) dfs(i,adj,dp,visited);
            for(i=1;i<=n;i++)
                ans=Math.max(ans,dp[i]);
            return ans;
        }
    }
}


