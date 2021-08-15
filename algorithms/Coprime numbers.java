//problem link-https://www.hackerearth.com/problem/algorithm/co-prime-numbers-2c558e1e/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,j,N=100000,p[]=new int[N+1];
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=i;j<=N;j+=i) p[j]=i;

        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            long ans=0; i=2;
            while(i<n)
            {
                int max=n/i;
                if(max<=i) break;

                ArrayList<Integer> f=new ArrayList<>();
                int x=i;
                while(x>1)  //find prime factors
                {
                    int pr=p[x];
                    while(x%pr==0) x/=pr;
                    f.add(pr);
                }

                int sz=f.size(),m=1<<sz,k,add=0,ev,mul;
                for(j=1;j<m;j++)    //count unique numbers that are divisible by atleast 1 prime factor 
                {
                    ev=0; mul=1;
                    for(k=0;k<sz;k++)
                    if(((j>>k)&1)==1)
                    {
                        mul*=f.get(k);
                        ev^=1;
                    }
                    if(ev==1) add+=max/mul-i/mul;
                    else add-=max/mul-i/mul;
                }

                ans+=(max-i)-add;   //numbers which are coprime
                i++;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
