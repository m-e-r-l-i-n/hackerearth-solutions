problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/suffix-arrays/practice-problems/algorithm/maximum-binary-number-2980dd7b/?layout=old

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
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),i;
            char c[]=bu.readLine().toCharArray();
            for(i=0;i<n;i++)
            c[i]=c[i]=='0'?'1':'0';

            int z[]=z_function(c),per=n;
            for(i=1;i<n;i++)
            if(i+z[i]==n && n%i==0) {per=i; break;}

            char a[]=new char[per];
            for(i=0;i<per;i++)
            a[i]=c[i];
            int v[]=shifts(a);
            long ans=1l*v[0]+1l*(k-1)*per;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int[] z_function(char s[])
    {
        int i,l,r,n=s.length,z[]=new int[n];
        for(i=1,l=0,r=0;i<n;i++) 
        {
            if(i<=r) z[i]=Math.min(r-i+1,z[i-l]);
            while(i+z[i]<n && s[z[i]]==s[i+z[i]]) ++z[i];
            if(i+z[i]-1>r) 
            {
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }

    static int[] shifts(char s[])
    {
        int n=s.length,sz=Math.max(100,n),i;
        int p[]=new int[n],c[]=new int[n],cnt[]=new int[sz];
        for(i=0;i<n;i++) cnt[s[i]]++;
        for(i=1;i<100;i++) cnt[i]+=cnt[i-1];
        for(i=0;i<n;i++) p[--cnt[s[i]]]=i;
        c[p[0]]=0;

        int sum=1;
        for(i=1;i<n;i++)
        {
            if(s[p[i]]!=s[p[i-1]])
                sum++;
            c[p[i]]=sum-1;
        }

        int j,pn[]=new int[n],cn[]=new int[n];
        for(j=0;(1<<j)<n;j++)
        {
            for(i=0;i<n;i++)
            {
                pn[i]=p[i]-(1<<j);
                if(pn[i]<0) pn[i]+=n;
            }
            Arrays.fill(cnt,0,sum, 0);
            for(i=0;i<n;i++) cnt[c[pn[i]]]++;
            for(i=1;i<sum;i++) cnt[i]+=cnt[i-1];
            for(i=n-1;i>=0;i--) p[--cnt[c[pn[i]]]]=pn[i];

            cn[p[0]]=0;
            sum=1;
            for(i=1;i<n; i++)
            {
                if(c[p[i]]!=c[p[i-1]] || c[(p[i]+(1<<j))%n]!=c[(p[i-1]+(1<<j))%n]) ++sum;
                cn[p[i]]=sum-1;
            }
            for(i=0;i<n;i++)
            {
                int t=c[i];
                c[i]=cn[i];
                cn[i]=c[i];
            }
        }
        return p;
    }
}
