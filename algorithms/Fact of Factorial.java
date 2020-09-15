problem link-https://www.hackerearth.com/problem/algorithm/fact-of-factorial-4/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine()),i,j,x,c[]=new int[121];
        for(i=2;i<=n;i++)
        {
            x=i;
            for(j=2;j*j<=x;j++)
            if(x%j==0)
            while(x%j==0) 
            {c[j]++; x/=j;}
            if(x>=2) c[x]++;
        }
        long ans=1;
        for(i=2;i<=120;i++)
        ans*=(c[i]+1);
        System.out.print(ans);
    }
}
