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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
            long l[]=new long[n+1],r[]=new long[n+1],p[]=new long[n];
            char c[]=bu.readLine().toCharArray();
            int i;
            p[0]=1;
            for(i=1;i<n;i++) p[i]=p[i-1]*10%k;
            for(i=n-1;i>=0;i--)
            {
                r[i]=p[n-i-1]*(c[i]-'0');
                r[i]+=r[i+1];
                r[i]%=k;
            }
            long ans=r[0];
            l[0]=(c[0]-'0')%k;
            for(i=1;i<n;i++) l[i]=(l[i-1]*10+(c[i]-'0'))%k;
            if(i>1) ans=Math.max(ans,r[1]);
            for(i=1;i<n;i++) ans=Math.max((l[i-1]*p[n-i-1]%k+r[i+1])%k,ans);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
