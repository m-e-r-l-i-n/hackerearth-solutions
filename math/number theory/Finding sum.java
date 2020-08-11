problem link-https://www.hackerearth.com/problem/algorithm/weird-sum-2-351e3c20/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int a[]=new int[n],i;
        long p[]=new long[n],inv[]=new long[n],f=1,M=1000000007;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            f*=a[i];
            f%=M;
            p[i]=f;
        }
        for(i=0;i<n;i++)
        inv[i]=modinverse(p[i],M);

        long ans=p[n/2-1]%M;
        for(i=1;i<=(n+1)/2;i++)
        {
            long val=p[i+n/2-1]%M*inv[i-1]%M;
            ans+=val;
            ans%=M;
        }
        System.out.print(ans);
    }

    static long modinverse(long a,long M)
    {
        long res=1,b=M-2;
        while(b!=0)
        {
            if((b&1)==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
