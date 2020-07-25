problem link-https://www.hackerearth.com/problem/algorithm/lcmk-a8c3e378/?layout=old

import java.io.*;
import java.util.*;
 
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        HashMap<Integer,HashMap<Integer,Integer>> global=new HashMap<>();
 
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),k=Integer.parseInt(s[2]);
            int i,j,x;
            s=bu.readLine().split(" ");
            HashMap<Integer,Integer> hm=new HashMap<>();
 
            //lcm is nothing but the product of maximum values of prime factors
            for(i=0;i<n;i++)
            {
                x=Integer.parseInt(s[i]);
                int u=x;
                if(global.get(x)==null)
                {
                    HashMap<Integer,Integer> temp=new HashMap<>();
                    for(j=2;j*j<=x;j++)
                    if(x%j==0)
                    {
                        int c=0;
                        while(x%j==0)
                        {
                            c++;
                            x/=j;
                        }
                        temp.put(j,c);
                    }
                    if(x>=2) temp.put(x,1);
                    global.put(u,temp);
                }
 
                for(int y:global.get(u).keySet())
                    hm.put(y,Math.max(hm.getOrDefault(y,0),global.get(u).get(y)));
            }
 
            long ans=1;
            for(int y:hm.keySet())
            {
                long pwr=1l*hm.get(y)*k;
                ans*=power(y,pwr,m);
                ans%=m;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
 
    static long power(long a,long b,long M)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
