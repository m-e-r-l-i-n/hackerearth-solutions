problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/maximum-spanning-tree/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            StringTokenizer st=new StringTokenizer(bu.readLine());
            int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),i;
            Graph g=new Graph(n,m);
            for(i=0;i<m;i++)
            {
                st=new StringTokenizer(bu.readLine());
                int l=Integer.parseInt(st.nextToken())-1,r=Integer.parseInt(st.nextToken())-1,c=Integer.parseInt(st.nextToken());
                c=-c;
                g.edge[i].src=l;
                g.edge[i].dest=r;
                g.edge[i].weight=c;
            }
            g.KruskalMST();
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }

    static class Graph
    {
        static class Edge implements Comparable<Edge>
        {
            int src,dest,weight;
            Edge(int a,int b,int c)
            {
                src=a;
                dest=b;
                weight=c;
            }

            public int compareTo(Edge com)
            {
                return weight-com.weight;
            }
        }
        static class Subset
        {
            int parent, rank;
        }

        static int V,E;
        static Edge edge[];
        Graph(int v, int e)
        {
            V=v;
            E=e;
            edge=new Edge[E];
            for(int i=0;i<e;++i) edge[i]=new Edge(0,0,0);
        }

        static int find(Subset subsets[], int i)
        {
            if(subsets[i].parent!=i) subsets[i].parent=find(subsets,subsets[i].parent);
            return subsets[i].parent;
        }

        static void union(Subset subsets[], int x, int y)
        {
            int xroot=find(subsets,x);
            int yroot=find(subsets,y);

            if(subsets[xroot].rank<subsets[yroot].rank) subsets[xroot].parent=yroot;
            else if(subsets[xroot].rank>subsets[yroot].rank) subsets[yroot].parent=xroot;
            else
            {
                subsets[yroot].parent=xroot;
                subsets[xroot].rank++;
            }
        }

        static void KruskalMST()    //Krukal's Minimum Spanning Tree
        {
            int e=0,i=0;
            Arrays.sort(edge);

            Subset subsets[]=new Subset[V];
            for(i=0;i<V;++i) subsets[i]=new Subset();

            for(i=0;i<V;++i)
            {
                subsets[i].parent=i;
                subsets[i].rank=0;
            }

            i=0; sum=0;
            while(e<V-1 && i<E)
            {
                Edge next_edge=new Edge(0,0,0);
                next_edge=edge[i++];

                int x=find(subsets,next_edge.src);
                int y=find(subsets,next_edge.dest);
                if(x!=y)
                {
                    sum+=next_edge.weight;
                    union(subsets,x,y);
                }
            }
            sum=-sum;
        }
    }
    static long sum;
}
