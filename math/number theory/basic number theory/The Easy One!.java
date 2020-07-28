problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/practice-problems/algorithm/the-easy-one-0de35805/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),N=100000,i;
        long f[]=new long[N+1],M=1000000007;
        f[0]=1;
        for(i=1;i<=N;i++)
        f[i]=f[i-1]*i%M;

        while(t-->0)
        {
            String s=bu.readLine();
            int c[]=new int[10];
            for(i=0;i<s.length();i++)
                c[s.charAt(i)-'0']++;
            long ans=f[s.length()];
            for(i=0;i<10;i++)
            ans=ans*power(f[c[i]],M-2,M)%M;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long power(long a,long b,long M)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
