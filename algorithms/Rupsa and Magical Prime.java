problem link-https://www.hackerearth.com/problem/algorithm/abc-40/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main (String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine().trim());
            //number of primitive roots of a prime n=phi of n-1 where phi is euler totient function value
            int p=phi(n-1);
            if(square(p)) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
    }
    
    static int phi(int n)
    {
        double res=n;
        int i;
        for(i=2;i*i<=n;i++) 
        {
            if(n%i==0) 
            {
                while(n%i==0) n/=i;
                res*=(1.0-(1.0/i));
            }
        }
        if(n>1)
            res*=(1.0-(1.0/n));
        return (int)res;
    }

    static boolean square(int n)
    {
        int f=(int)Math.sqrt(n);
        return f*f==n;
    }
}
