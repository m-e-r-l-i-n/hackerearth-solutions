problem link-https://www.hackerearth.com/problem/algorithm/simple-math-1/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main (String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
        System.out.print(ncr(n-1,r-1));
    }

    static long ncr(int n,int r)
    {
        if(n<r) return -1;
        long deno=1,num=1,M=10000007;
        for(int i=0;i<r;i++)
        {
            deno*=n-i;
            num*=i+1;
            long g=gcd(deno,num);
            deno/=g;
            num/=g;
        }
        long ans=deno/num%M;
        if(ans<0) ans=7708211;
        return ans;
    }

    static long gcd(long a,long b)
    {
        long t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
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
