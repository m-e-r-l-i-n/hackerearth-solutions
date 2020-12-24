problem link-https://www.hackerearth.com/problem/algorithm/final-question/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=fr.nextInt(),q=fr.nextInt(),k=fr.nextInt();
        int a[]=new int[n],i,b[][]=new int[500][k];
        for(i=0;i<n;i++)
        {
            a[i]=fr.nextInt()%k;
            b[i/500][a[i]]++;
        }

        while(q-->0)
        {
            int t=fr.nextInt();
            if(t==1)
            {
                int l=fr.nextInt(),r=fr.nextInt();
                int bl=l/500,br=r/500,ans=0;
                if(bl==br)
                {
                    int add=(int)(query(bl)%k);
                    for(i=l;i<=r;i++)
                    if((a[i]+add)%k==0) ans++;
                }
                else
                {
                    int lp=l-1,rp=r+1;
                    if(l%500!=0) lp=(bl+1)*500-1;
                    if(r%500!=499) rp=br*500;
                    int addl=(int)(query(bl)%k),addr=(int)(query(br)%k);

                    while(lp>=l || rp<=r)
                    {
                        if(lp>=l && lp<n && (a[lp]+addl)%k==0) ans++;
                        if(rp<=r && rp>0 && (a[rp]+addr)%k==0) ans++;
                        lp--; rp++;
                    }

                    if(l%500!=0) bl++;
                    if(r%500!=499) br--;
                    for(i=bl;i<=br;i++)
                    {
                        int add=(int)(query(i)%k);
                        if(add==0) ans+=b[i][0];
                        else ans+=b[i][k-add];
                    }
                }
                sb.append(ans+"\n");
            }
            else
            {
                int l=fr.nextInt(),r=fr.nextInt(),y=fr.nextInt()%k;
                int bl=l/500,br=r/500;
                if(bl==br)
                {
                    for(i=l;i<=r;i++)
                    {
                        b[bl][a[i]]--;
                        a[i]=(a[i]+y)%k;
                        b[bl][a[i]]++;
                    }
                }
                else
                {
                    int lp=l-1,rp=r+1;
                    if(l%500!=0) lp=(bl+1)*500-1;
                    if(r%500!=499) rp=br*500;

                    while(lp>=l || rp<=r)
                    {
                        if(lp>=l)
                        {
                            b[bl][a[lp]]--;
                            a[lp]+=y;
                            a[lp]%=k;
                            b[bl][a[lp]]++;
                        }
                        if(rp<=r)
                        {
                            b[br][a[rp]]--;
                            a[rp]+=y;
                            a[rp]%=k;
                            b[br][a[rp]]++;
                        }
                        lp--; rp++;
                    }

                    if(l%500!=0) bl++;
                    if(r%500!=499) br--;
                    update(bl,y);
                    update(br+1,-y);
                }
            }
        }
        System.out.print(sb);
    }
    static int N=500; 
    static long bit[]=new long[N+5];
    static long query(int i)
    {
        i++;
        long sum=0;
        while(i>0)
        {
            sum+=bit[i];
            i-=i&-i;
        }
        return sum;
    }

    static void update(int i,int v)
    {
        i++;
        while(i<=N)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }

    static class FastReader
    {
        final private int BUFFER_SIZE=1<<16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer,bytesRead;

        public FastReader()
        {
            dis=new DataInputStream(System.in);
            buffer=new byte[BUFFER_SIZE];
            bufferPointer=bytesRead=0;
        }

        public int nextInt() throws IOException
        {
            int ret=0;
            byte c=read();
            while(c<=' ') c=read();
            boolean neg=(c=='-');
            if(neg) c=read();
            do
            {
                ret=ret*10+c-'0';
            }while((c=read())>='0' && c<='9');
            if(neg) return -ret;
            return ret;
        }

        private void fillBuffer()throws IOException
        {
            bytesRead=dis.read(buffer,bufferPointer=0,BUFFER_SIZE);
            if(bytesRead==-1) buffer[0]=-1;
        }
        private byte read() throws IOException
        {
            if(bufferPointer==bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
