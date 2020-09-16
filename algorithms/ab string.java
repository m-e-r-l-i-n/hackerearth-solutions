problem link-https://www.hackerearth.com/problem/algorithm/ab-string-1-018a59e9/description/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s=bu.readLine();
            int n=s.length();
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
            int ch=s.charAt(0);
            p[0]=ch=='a'?1:0;
            p[1]=ch=='b'?1:0;

            for(i=1;i<n;i++)
            {
                ch=s.charAt(i);
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
}
