problem link-https://www.hackerearth.com/problem/algorithm/raymond-and-series/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        /*
        we need to find Number of binary vectors of length N containing no singletons
        where N=n+5(n>1)
        now t(N)=F(N-1,N-2)
        where F(n,k)=(n-k+1)*F(k,k)
        F(k,k)=(k+1)th fibonacci number
        so, F(N-1,N-2)=2*(N-1)th fibonacci number
         */

        int t=fr.nextInt();
        while(t-->0)
        {
            long n=fr.nextLong();
            if(n==1) {sb.append("8\n"); continue;}
            n+=4;
            long ans[]=new long[2];
            fibo(n,ans);  //nth fibonacci number;
            ans[0]*=2;
            ans[0]%=M;
            sb.append(ans[0]+"\n");
        }
        System.out.print(sb);
    }
    static long M=1000000007;

    static void fibo(long n,long ans[])
    {
        if(n==0)
        {
            ans[0]=0;
            ans[1]=1;
            return;
        }

        long a,b,c,d;
        fibo(n/2,ans);
        a=ans[0];   //f(n)
        b=ans[1];   //f(n+1)
        c=2*b-a+M;
        c%=M;
        c=(a*c)%M;  //f(2n)
        d=(a*a+b*b)%M;  //f(2n+1)
        if(n%2==0)
        {ans[0]=c; ans[1]=d;}
        else
        {ans[0]=d; ans[1]=(c+d)%M;}
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st==null || !st.hasMoreElements())
            {
                try
                {st=new StringTokenizer(br.readLine());}
                catch(IOException e)
                {e.printStackTrace();}
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }
    }
}
