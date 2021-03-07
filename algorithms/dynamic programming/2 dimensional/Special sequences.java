import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt();
        while(t-->0)
        {
            n=fr.nextInt(); m=fr.nextInt();
            int i;
            for(i=0;i<n;i++) a[i]=fr.nextInt();
            for(i=0;i<m;i++) b[i]=fr.nextInt();
            for(i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
            dp[i][j][0]=dp[i][j][1]=-1;
            int ans=solve(0,0,1,-1000000);
            for(i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
            dp[i][j][0]=dp[i][j][1]=-1;
            ans=Math.max(ans,solve(0,0,0,-1000000));
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int N=2005,dp[][][]=new int[N][N][2],n,m,a[]=new int[N],b[]=new int[N];
    static int solve(int i,int j,int t,int l)
    {
        if(i>=n && t==0) return 0;
        if(j>=m && t==1) return 0;
        if(i<n && j<m && dp[i][j][t]!=-1) return dp[i][j][t];

        if(t==0)
        {
            int rt=0;
            if(a[i]>l) rt=1+solve(i+1,j,t^1,a[i]);
            rt=Math.max(rt,solve(i+1,j,t,l));
            dp[i][j][t]=rt;
            return rt;
        }
        else
        {
            int rt=0;
            if(b[j]>l) rt=1+solve(i,j+1,t^1,b[j]);
            rt=Math.max(rt,solve(i,j+1,t,l));
            dp[i][j][t]=rt;
            return rt;
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
