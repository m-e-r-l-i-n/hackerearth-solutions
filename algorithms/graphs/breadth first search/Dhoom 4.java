problem link-https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/dhoom-4/?layout=old

import java.io.*;
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int k=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        int i,j,M=100000,c=1,n=Integer.parseInt(bu.readLine()),a[]=new int[n];
        boolean vis[]=new boolean[M+1]; k%=M;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
 
        Queue<Integer> q=new LinkedList<>();
        vis[k]=true; q.add(k);
        while(true)
        {
            int size=q.size(),change=0,solve=0;
            for(i=0;i<size;i++)
            {
                long cur=q.poll();
                for(j=0;j<n;j++)
                {
                    int t=(int)(cur*a[j]%M);
                    if(!vis[t])
                    {
                        q.add(t); 
                        vis[t]=true;
                        change=1;
                        if(t==m) {solve=1; break;}
                    }
                }
                if(solve==1) break;
            }
            if(change==0) {System.out.print("-1"); return;}
            if(solve==1) {System.out.print(c); return;}
            c++;
        }
    }
}
