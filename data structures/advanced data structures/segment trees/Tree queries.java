import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt(),N=100000,d[]=new int[N+1];
        long a[]=new long[N+1],ma[]=new long[N+1];
        while(t-->0)
        {
            int n=fr.nextInt(),i;
            ArrayList<Integer> g[]=new ArrayList[n];
            for(i=0;i<n;i++)
            {
                a[i]=fr.nextInt();
                g[i]=new ArrayList<>();
            }
            for(i=0;i<n-1;i++)
            {
                int u=fr.nextInt()-1,v=fr.nextInt()-1;
                g[u].add(v);
                g[v].add(u);
            }

            boolean vis[]=new boolean[n];
            vis[0]=true;
            Queue<Integer> q=new LinkedList<>();
            q.add(0);
            int maxd=0;
            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int x:g[p])
                if(!vis[x])
                {
                    vis[x]=true;
                    d[x]=d[p]+1;
                    maxd=Math.max(maxd,d[x]);
                    q.add(x);
                }
            }
            
            for(i=0;i<=maxd;i++) ma[i]=0;
            for(i=0;i<n;i++) ma[d[i]]=Math.max(ma[d[i]],a[i]);
            for(i=0;i<=maxd;i++) update(0,maxd,i,ma[i],0);
            
            int qr=fr.nextInt();
            while(qr-->0)
            {
                int ty=fr.nextInt();
                if(ty==1)
                {
                    i=fr.nextInt()-1;
                    long v=fr.nextInt();
                    a[i]+=v;
                    v=ma[d[i]];
                    if(a[i]>v)
                    {
                        ma[d[i]]=a[i];
                        update(0,maxd,d[i],a[i],0);
                    }
                }
                else
                {
                    long k=fr.nextLong();
                    int l=0,r=maxd,m,ans=r;
                    long max=query(0,maxd,0,maxd,0);
                    if(max<=k) {sb.append("-1\n"); continue;}
                    if(ma[0]>k) {sb.append("0\n"); continue;}
                    while(l<=r)
                    {
                        m=(l+r)>>1;
                        long v=query(0,maxd,0,m,0);
                        if(v>k)
                        {
                            ans=m;
                            r=m-1;
                        }
                        else l=m+1;
                    }
                    sb.append(ans+"\n");
                }
            }
        }
        System.out.print(sb);
    }

    static long st[]=new long[500000];
    static void update(int ss,int se,int i,long v,int n)
    {
        if(i<ss || i>se) return;
        if(ss==se)
        {
            st[n]=v;
            return;
        }
        int m=ss+(se-ss)/2;
        if(i>=ss && i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=Math.max(st[2*n+1],st[2*n+2]);
    }

    static long query(int ss,int se,int l,int r,int n)
    {
        if(l<=ss && r>=se) return st[n];
        if(se<l || ss>r) return -1;

        int m=ss+(se-ss)/2;
        return Math.max(query(ss,m,l,r,2*n+1),query(m+1,se,l,r,2*n+2));
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

        public long nextLong() throws IOException
        {
            long ret=0;
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
