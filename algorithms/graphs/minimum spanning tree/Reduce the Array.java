//problem link-https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/reduce-the-array-2-2a1e3e02/

//has bad inputs
import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        
        int a[]=new int[n],i,p[]=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }});
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            p[i]=i;
            for(int j=0;j<i;j++) pq.add(new int[]{a[i]+a[j]+(a[i]|a[j])-(a[i]&a[j]),i,j});
        }

        int ans=0;
        while(!pq.isEmpty())
        {
            int e[]=pq.poll();
            int u=e[1],v=e[2];
            u=parent(p,u); v=parent(p,v);
            if(u==v) continue;

            ans|=e[0];
            p[u]=v;
        }
        System.out.println(ans);
    }

    static int parent(int p[],int i)
    {
        Stack<Integer> st=new Stack<>();
        while(p[i]!=i)
        {
            st.add(i);
            i=p[i];
        }
        while(!st.isEmpty()) p[st.pop()]=i;
        return i;
    }
}
