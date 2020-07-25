problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/path-queries-ba308c8e/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=bu.nextInt(),i,a[]=new int[n];
        for(i=0;i<n;i++)
            a[i]=bu.nextInt();

        g=new ArrayList[n+1];
        Node no[]=new Node[n+1]; int p2[]=new int[31],cnt[]=new int[31];
        for(i=0;i<=n;i++)
            g[i]=new ArrayList<>();
        for(i=0;i<n-1;i++)
        {
            int u=bu.nextInt(),v=bu.nextInt();
            g[u].add(v); g[v].add(u);
        }

        boolean vis[]=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1); vis[1]=true;
        no[0]=new Node(0,0,0,p2);
        no[1]=new Node(0,0,0,p2);
        fill(no[1],1,0,a[0],a[0]);
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(int x:g[p])
            if(!vis[x])
            {
                vis[x]=true;
                no[x]=new Node(no[p].p+1,p,no[p].sum,no[p].bits);
                fill(no[x],no[p].p+1,p,a[x-1],a[x-1]);
                q.add(x);
            }
        }
        p2[0]=1;
        for(i=1;i<31;i++)
            p2[i]=2*p2[i-1];
        eulertour(n);

        int t=bu.nextInt();
        while(t-->0)
        {
            int c=bu.nextInt(),u=bu.nextInt(),v=bu.nextInt();
            int lca=lca(u-1,v-1);
            if(c==1)
            {
                long ans=no[v].sum-no[lca].sum+M;
                ans%=M;
                ans+=no[u].sum-no[lca].sum+M;
                ans%=M;
                ans+=a[lca-1];
                ans%=M;
                sb.append(ans+"\n");
            }

            else
            {
                long ans=0;
                int el=no[v].p-no[lca].p+no[u].p-no[lca].p+1,x=a[lca-1],cr=0;
                for(i=0;i<31;i++)
                {
                    cnt[i]=no[v].bits[i]-no[lca].bits[i];
                    cnt[i]+=no[u].bits[i]-no[lca].bits[i];
                    if(((x>>i)&1)==1) cnt[i]++;
                }

                if(c==2)
                for(i=0;i<31;i++)
                {
                    int k1=cnt[i],k0=el-cnt[i];
                    ans+=1l*p2[i]*k1*(k1-1)/2+1l*p2[i]*k1*k0;
                    ans%=M;
                }
                else if(c==3)
                for(i=0;i<31;i++)
                {
                    int k1=cnt[i],k0=el-cnt[i];
                    long val=ncr(k1,3);
                    val+=ncr(k1,2)*k0%M;
                    val%=M;
                    val+=ncr(k0,2)*k1%M;
                    val%=M;
                    ans+=(1l*p2[i]*val)%M;
                    ans%=M;
                }
                else
                for(i=0;i<31;i++)
                {
                    int k1=cnt[i],k0=el-cnt[i];
                    long val=ncr(k1,4);
                    val+=ncr(k1,3)*k0%M;
                    val%=M;
                    val+=ncr(k1,2)*ncr(k0,2)%M;
                    val%=M;
                    val+=ncr(k0,3)*k1%M;
                    val%=M;
                    ans+=(1l*p2[i]*val)%M;
                    ans%=M;
                }
                sb.append(ans+"\n");
            }
        }
        System.out.print(sb);
    }
    static long M=1000000007;
    static ArrayList<Integer> g[];

    static void fill(Node n,int p,int prev,long sum,int a)
    {
        n.p=p;
        n.prev=prev;
        n.sum+=sum;
        n.sum%=M;
        for(int i=0;i<31;i++)
            if(((a>>i)&1)==1) n.bits[i]++;
    }

    static long ncr(int n,int k)
    {
        if(k>n) return 0;
        long ans=1,x=n;
        if(k==2)
        {
            ans=x*(x-1);
            ans/=2;
        }
        else if(k==3)
        {
            ans=x*(x-1)*(x-2);
            ans/=6;
        }
        else
        {
            ans=x*(x-1)/2;
            long g=gcd((x-2)*(x-3),12),tw=12;
            x=(x-2)*(x-3)/g;
            tw/=g;
            ans=(ans*x)/tw;
        }
        ans%=M;
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

    static class Node
    {
        int p,prev,bits[];
        long sum;
        Node(int a,int y,long b,int x[])
        {
            p=a;
            prev=y;
            sum=b;
            bits=new int[31];
            for(int i=0;i<31;i++)
                bits[i]=x[i];
        }
    }

    static int level[],first[],st[],euler[];
    static void eulertour(int n)
    {
        ArrayList<Integer> tour=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        Stack<Integer> levl=new Stack<>();
        boolean vis[]=new boolean[n+1];
        s.add(1);
        levl.add(1);
        while(!s.isEmpty())
        {
            int p=s.pop(),lev=levl.pop();
            if(!vis[p])
            {
                vis[p]=true;
                for(int x:g[p])
                if(!vis[x])
                {
                    s.add(p); levl.add(lev);
                    s.add(x); levl.add(lev+1);
                }
            }
            tour.add(p); l.add(lev);
        }
        first=new int[n];
        level=new int[l.size()]; euler=new int[l.size()];
        for(int i=0;i<tour.size();i++)
        {
            if(first[tour.get(i)-1]==0) first[tour.get(i)-1]=i+1;
            level[i]=l.get(i);
            euler[i]=tour.get(i);
        }
        int no=level.length,x=(int)(Math.log(no)/Math.log(2))+1;
        int size=2*(1<<x)-1;
        st=new int[size];
        build(0,0,no-1);
    }

    static void build(int i,int ss,int se)
    {
        if(ss==se) st[i]=ss;
        else
        {
            int mid=(ss+se)/2;
            build(i*2+1,ss,mid);
            build(i*2+2,mid+1,se);
            if(level[st[2*i+1]]<level[st[2*i+2]]) st[i]=st[2*i+1];
            else st[i]=st[2*i+2];
        }
    }

    static int rmq(int i,int l,int r,int x,int y)
    {
        if(x<=l && y>=r) return st[i];
        else if(r<x || l>y) return -1;

        int mid=(l+r)/2;
        int q1=rmq(2*i+1,l,mid,x,y),q2=rmq(2*i+2,mid+1,r,x,y);
        if(q1==-1) return q2;
        else if(q2==-1) return q1;

        return level[q1]<level[q2]?q1:q2;
    }

    static int lca(int u,int v)
    {
        if(first[u]>first[v]) u=u^v^(v=u);
        int x=first[u]-1,y=first[v]-1;
        int i=rmq(0,0,level.length-1,x,y);
        return euler[i];
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
