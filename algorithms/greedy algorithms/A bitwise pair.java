import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int N=1000,c[]=new int[N+1],a,i,j;
            String s[]=bu.readLine().split(" ");
            long ans=0;
            for(i=0;i<n;i++)
            {
                a=Integer.parseInt(s[i]);
                c[a]++;
            }
            for(i=1;i<=N;i++)
            for(j=1;j<=N;j++)
            if(((i|j)-(i&j))==(i-j)) ans+=c[i]*c[j];
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
