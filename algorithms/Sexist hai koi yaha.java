problem link-https://www.hackerearth.com/problem/algorithm/sexist-hai-koi/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int i,j,N=1000000;

        int n=fr.nextInt(),a[]=new int[n],c[]=new int[N+1];
        for(i=0;i<n;i++)
        {
            a[i]=fr.nextInt();
            int x=a[i];
            for(j=2;j*j<=x;j++)
            if(x%j==0)
            {
                c[j]++;
                while(x%j==0) x/=j;
            }
            if(x>=2) c[x]++;
        }

        int ans=0;
        for(i=0;i<n;i++)
        {
            boolean pos=true;
            for(j=2;j*j<=a[i];j++)
            if(a[i]%j==0)
            {
                if(c[j]>1) {pos=false; break;}
                while(a[i]%j==0) a[i]/=j;
            }
            if(a[i]>=2 && c[a[i]]>1) pos=false;
            if(pos) ans++;
        }
        System.out.print(ans);
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
    }
}
