//problem link-https://www.hackerearth.com/problem/algorithm/pipeline-and-probe-4f2c1064/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt();
        while(t-->0)
        {
            int n=fr.nextInt(),m=fr.nextInt(),sx=fr.nextInt(),sy=fr.nextInt(),l=fr.nextInt();
            int i,j,c[][]=new int[n][m],x=0;
            ArrayList<Integer> g[]=new ArrayList[n*m];
            boolean d[][]=new boolean[n*m][4];
            for(i=0;i<n;i++)
            for(j=0;j<m;j++)
            {
                c[i][j]=x;
                g[x]=new ArrayList<>();
                x++;
            }

            for(i=0;i<n;i++)
            for(j=0;j<m;j++)
            {
                x=fr.nextInt();
                boolean left=false,right=false,up=false,down=false;
                if(x==1 || x==2 || x==4 || x==7) up=true;
                if(x==1 || x==2 || x==5 || x==6) down=true;
                if(x==1 || x==3 || x==6 || x==7) left=true;
                if(x==1 || x==3 || x==4 || x==5) right=true;
                d[c[i][j]][0]=up; d[c[i][j]][1]=down; d[c[i][j]][2]=left; d[c[i][j]][3]=right;
            }

            for(i=0;i<n;i++)
            for(j=0;j<m;j++)
            {
                if(d[c[i][j]][0] && i-1>=0 && d[c[i-1][j]][1]) g[c[i][j]].add(c[i-1][j]);
                if(d[c[i][j]][1] && i+1<n && d[c[i+1][j]][0]) g[c[i][j]].add(c[i+1][j]);
                if(d[c[i][j]][2] && j-1>=0 && d[c[i][j-1]][3]) g[c[i][j]].add(c[i][j-1]);
                if(d[c[i][j]][3] && j+1<m && d[c[i][j+1]][2]) g[c[i][j]].add(c[i][j+1]);
            }

            boolean vis[]=new boolean[n*m];
            Queue<Integer> q=new LinkedList<>();
            vis[c[sx][sy]]=true;
            q.add(c[sx][sy]); q.add(l);
            while(!q.isEmpty())
            {
                int p=q.poll(),dis=q.poll();
                if(dis==1) continue;
                for(int y:g[p])
                if(!vis[y])
                {
                    vis[y]=true;
                    q.add(y); q.add(dis-1);
                }
            }

            int ans=0;
            for(i=0;i<n*m;i++)
            if(vis[i]) ans++;
            if(ans==1) ans=0;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
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
