problem link-https://www.hackerearth.com/problem/algorithm/dance-of-dragons/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=1000000,i,j;
        long phi[]=new long[N+1],f[]=new long[N+1],M=1000000007;
        for(i=0;i<=N;i++)
        phi[i]=i;

        //calculate euler totient functions of all numbers
        for(i=2;i<=N;i++)
        if(phi[i]==i)
        {
            phi[i]=i-1;
            for(j=2*i;j<=N;j+=i)
            phi[j]=(phi[j]/i)*(i-1);
        }
        f[0]=f[1]=1;
        for(i=2;i<=N;i++)
        f[i]=f[i-1]*phi[i-1]%M;

        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            i=Integer.parseInt(bu.readLine());
            sb.append(f[i]+"\n");
        }
        System.out.print(sb);
    }

}
