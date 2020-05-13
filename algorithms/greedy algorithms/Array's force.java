problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/arrays-force-easy-contest/

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[2]),M=Integer.parseInt(s[3]),a[]=new int[n],i;
            a[0]=Integer.parseInt(s[0]); a[1]=Integer.parseInt(s[1]);
            HashMap<Integer,Integer> hm=new HashMap<>();
            hm.put(a[0],1);
            if(hm.get(a[1])==null) hm.put(a[1],1);
            else hm.put(a[1],2);
            for(i=2;i<n;i++)
            {
                a[i]=(a[i-1]+a[i-2])%M;
                if(hm.get(a[i])==null) hm.put(a[i],1);
                else hm.put(a[i],hm.get(a[i])+1);
            }
            long ans=0;
            for(int x:hm.keySet())
            ans+=1l*hm.get(x)*hm.get(x);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
