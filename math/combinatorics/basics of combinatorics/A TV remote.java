problem link-https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/tv-and-remote-183262c5/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,N=100000;
        long f[]=new long[N+1],M=1000000007;
        f[0]=1;
        for(i=1;i<=N;i++)
        f[i]=(f[i-1]*i)%M;

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            long ans=1;
            for(i=2;i<=n;i+=2)
            {
                long x=(f[n]*power(f[i],M-2,M)%M*power(f[n-i],M-2,M)%M)%M;  //nCr(n,i)
                long y=(f[i]*power(f[i/2],M-2,M)%M*power(f[i-i/2],M-2,M)%M)%M;  //nCr(i,i/2)
                ans+=(x*y)%M;
                ans%=M;
            }
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
