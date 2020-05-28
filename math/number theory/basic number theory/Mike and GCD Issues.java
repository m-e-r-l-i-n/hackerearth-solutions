problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/mike-and-gcd-issues/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int i,n=Integer.parseInt(bu.readLine()),p[]=new int[2*100000+1],pr[]=new int[n],su[]=new int[n];
        ArrayList<Integer> a[]=new ArrayList[n];
        ArrayList<Integer> ar[]=new ArrayList[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            int k=Integer.parseInt(s[i]),j;
            a[i]=new ArrayList<>();;
            ar[n-i-1]=new ArrayList<>();
            for(j=2;j*j<=k;j++)
            if(k%j==0)
            {
                a[i].add(j); ar[n-i-1].add(j);
                while(k%j==0) k/=j;
                //System.out.print(k);
            }
            if(k>=2) {a[i].add(k); ar[n-i-1].add(k);}
            int max=0;
            for(j=0;j<a[i].size();j++)
            {
                if(p[a[i].get(j)]>max) max=p[a[i].get(j)];
                p[a[i].get(j)]=i+1;
            }
            pr[i]=max; 
        }
        Arrays.fill(p,0);
        for(i=0;i<n;i++)
        {
            int max=0,j;
            for(j=0;j<ar[i].size();j++)
            {
                if(p[ar[i].get(j)]>max) max=p[ar[i].get(j)];
                p[ar[i].get(j)]=i+1;
            }
            su[n-i-1]=max; 
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<n;i++)
        {
            if(pr[i]==0 && su[i]==0) sb.append("-1 ");
            else if(pr[i]>0 && su[i]==0) sb.append(pr[i]+" ");
            else if(pr[i]==0 && su[i]>0) sb.append(n-su[i]+1+" ");
            else
            {
                int d1=i+1-pr[i],d2=n-i-su[i];
                if(d1<=d2) sb.append(pr[i]+" ");
                else sb.append(n-su[i]+1+" ");
            }
        }
        System.out.print(sb);
    }
}
