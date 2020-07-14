problem link-https://www.hackerearth.com/problem/algorithm/prime-5/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,j,N=1000000;
        ArrayList<Integer> pr[]=new ArrayList[N+1];
        for(i=0;i<=N;i++)
        pr[i]=new ArrayList<>();

        for(i=2;i<=N;i++)
        if(pr[i].size()==0)
        for(j=i;j<=N;j+=i)
        pr[j].add(i);

        while(t-->0)
        {
            String st[]=bu.readLine().split(" ");
            int n=Integer.parseInt(st[0]),k=Integer.parseInt(st[1]),q=0,p=0,s=pr[n].size();
            for(i=0;i<pr[n].size();i++)
            {
                q+=pr[n].get(i);
                p+=pr[n].get(i)-1;
            }
            sb.append(n+k+q-p-s+"\n");
        }
        System.out.print(sb);
    }
}
