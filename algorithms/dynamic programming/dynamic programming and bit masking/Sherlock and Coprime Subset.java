problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/practice-problems/algorithm/sherlock-and-coprime-subset/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        int pr[]={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
        int p[]=new int[51],key[]=new int[51],i;
        for(i=0;i<pr.length;i++) p[pr[i]]=i;

        for(i=2;i<=50;i++)
        {
            int j,x=i,mask=0;
            for(j=2;j*j<=x;j++)
            if(x%j==0)
            {
                mask|=1<<p[j];
                while(x%j==0) x/=j;
            }
            if(x>=2) mask|=1<<p[x];
            key[i]=mask;
        }

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int o=0,a,l=1<<pr.length;
            int c[]=new int[l];
            String s[]=bu.readLine().split(" ");
            Set<Integer> st=new HashSet<>();
            for(i=0;i<n;i++)
            {
                a=Integer.parseInt(s[i]);
                if(a==1) {o++; continue;}
                st.add(a);
            }
            for(int x:st)
            {
                x=key[x];
                for(i=1;i<l;i++)
                if(c[i]>0 && ((i|x)==(i^x))) c[i|x]=Math.max(c[i|x],c[i]+1);
                c[x]=Math.max(c[x],1);
            }
            int ans=0;
            for(i=0;i<l;i++)
            ans=Math.max(ans,c[i]);
            sb.append(ans+o+"\n");
        }
        System.out.print(sb);
    }
}
