problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/question-5-13-d4eab947/?layout=old

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
            int n=fr.nextInt();
            /*
            6 states-
            1.a
            2.b
            3.ab
            4.ba
            5.aba
            6.bab
             */
            int i,j,ans=1,c[]=new int[6],p[]=new int[6];
            int ch=fr.read();
            p[0]=ch=='a'?1:0;
            p[1]=ch=='b'?1:0;

            for(i=1;i<n;i++)
            {
                ch=fr.read();
                for(j=0;j<6;j++) c[j]=p[j];
                if(ch=='a')
                {
                    c[0]++;
                    c[3]=Math.max(p[3]+1,p[1]+1);
                    c[4]=Math.max(p[4]+1,p[2]+1);
                }
                else
                {
                    c[1]++;
                    c[2]=Math.max(p[0]+1,p[2]+1);
                    c[5]=Math.max(p[3]+1,p[5]+1);
                }

                for(j=0;j<6;j++)
                {
                    ans=Math.max(ans,c[j]);
                    p[j]=c[j];
                }
            }
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
