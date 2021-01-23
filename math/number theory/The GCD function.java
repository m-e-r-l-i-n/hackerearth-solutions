problem link-https://www.hackerearth.com/problem/algorithm/gcd-function-9fe49c14/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i;
            long lcm=1;
            for(i=1;i<=n;i++)
            lcm=lcm*i/gcd(lcm,i);
            long ans=0;
            for(i=1;i<=n;i++)
            ans+=gcd(lcm,i);
            sb.append(ans+" "+lcm+"\n");
        }
        System.out.print(sb);
    }

    static long gcd(long a,long b)
    {
        while(b!=0)
        {
            long t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
