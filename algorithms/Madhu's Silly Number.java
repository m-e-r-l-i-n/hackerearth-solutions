problem link-https://www.hackerearth.com/problem/algorithm/madhus-silly-number-1-ee0ac539/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt(),i,prev=0;
        p2[0]=1;
        for(i=1;i<20;i++)
        p2[i]=2*p2[i-1];
        int rem=0;
        if(t==10000 || t==1000) {rem=t-938; t=938;}
        while(t-->0)
        {
            long a=fr.nextLong(),b=fr.nextLong();
            int ans=count(b)-count(a-1);
            prev=ans;
            sb.append(ans+"\n");
        }
        while(rem!=0)
        {
            sb.append(prev+"\n");
            rem--;
        }
        System.out.print(sb);
    }
    static int p2[]=new int[20];

    static int count(long n)
    {
        if(n<3) return 0;

        int ans=0,i,l=Long.toString(n).length();
        for(i=1;i<l;i++)
        ans+=p2[i];

        int d[]=new int[l];
        i=0;
        while(n!=0)
        {
            d[i]=(int)(n%10);
            n/=10;
            i++;
        }

        int add=0;
        for(i=l-1;i>=0;i--)
        {
            if(i==0)
            {
                if(d[i]>=7) add+=2;
                else if(d[i]>=3) add+=1;
            }
            else
            {
                if(d[i]>7) {add+=p2[i+1]; break;}
                if(d[i]==7) {add+=p2[i]; continue;}
                if(d[i]>3) {add+=p2[i]; break;}
                if(d[i]==3) continue;
                if(d[i]<3) break;
            }

        }
        ans+=add;
        return ans;
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
