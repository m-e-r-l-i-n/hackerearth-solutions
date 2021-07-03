//problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/ororor-5ea10c51/

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),x=Integer.parseInt(s[1]);
            int i,j,a[]=new int[n],nxt[][]=new int[n+1][31];
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++) a[i]=Integer.parseInt(s[i]);

            for(i=0;i<31;i++) nxt[n][i]=n;
            for(i=n-1;i>=0;i--)
            for(j=0;j<31;j++)
            {
                nxt[i][j]=nxt[i+1][j];
                if(((a[i]>>j)&1)==1) nxt[i][j]=i;
            }

            int max=n+1; ArrayList<Integer> ans=new ArrayList<>();
            for(i=0;i<n;i++)
            {
                int l=i,c=0;
                PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0]>o2[0]) return 1;
                        else return -1;
                    }});
                for(j=0;j<31;j++)
                pq.add(new int[]{nxt[i][j],j});

                while(!pq.isEmpty() && c<x)
                {
                    c|=1<<pq.peek()[1];
                    l=Math.max(l,pq.peek()[0]);
                    pq.poll();
                }

                if(l!=n && l-i+1<=max)
                {
                    if(l-i+1<max) {max=l-i+1; ans=new ArrayList<>();}
                    ans.add(i+1); ans.add(l+1);
                }
            }

            sb.append(ans.size()/2+"\n");
            for(i=0;i<ans.size();i+=2) sb.append(ans.get(i)+" "+ans.get(i+1)+"\n");
        }
        System.out.print(sb);
    }
}
