problem link-https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/prom-night/description/

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
            int i, b[]=new int[n],g[]=new int[m];
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            b[i]=Integer.parseInt(s[i]);
            s=bu.readLine().split(" ");
            if(n>m) {sb.append("NO\n"); continue;}
            for(i=0;i<m;i++)
            g[i]=Integer.parseInt(s[i]);

            Arrays.sort(b); Arrays.sort(g);
            boolean flag=true;
            for(i=0;i<n;i++)
            if(g[i]>=b[i]) {flag=false; break;}
            if(flag) sb.append("YES\n");
            else sb.append("NO\n"); 
        }
        System.out.print(sb);
    }
}
