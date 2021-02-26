problem link-https://www.hackerearth.com/problem/algorithm/little-shino-and-prime-difference-38c91b0d-df362f49/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=1000000,i,j;
        boolean p[]=new boolean[N+1];
        p[0]=p[1]=true;
        for(i=2;i<=N;i++)
        if(!p[i])
        for(j=2*i;j<=N;j+=i)
        p[j]=true;

        int a,n=Integer.parseInt(bu.readLine()),max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a=Integer.parseInt(s[i]);
            if(!p[a])
            {
                min=Math.min(min,a);
                max=Math.max(max,a);
            }
        }
        if(min==Integer.MAX_VALUE) sb.append(-1);
        else sb.append(max-min);
        System.out.print(sb);
    }
}
