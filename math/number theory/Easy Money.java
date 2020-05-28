problem link-https://www.hackerearth.com/problem/algorithm/easy-money/?layout=old

import java.io.*;
 
class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(bu.readLine());
        long i,ans=1,m=1000000007;
        ans=power(n,m-1);
        ans=power(ans,m);
        System.out.print(ans-1);    
    }
 
    static long power(long b,long m)
    {
        long x=2,res=1;
        while(b!=0)
        {
            if(b%2==1) res=(res*x)%m;
            b>>=1;
            x=(x*x)%m;
        }
        return res;
    }
}
