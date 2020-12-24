problem link-https://www.hackerearth.com/problem/algorithm/the-counting-problem/?layout=old

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
            int n=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            int a[]=new int[n],i; long ans=0;
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                ans+=i-query(a[i]);     //number of elements greater=total-smaller
                update(a[i],1);
            }
            if(t!=0)
            for(i=0;i<n;i++)
            update(a[i],-1);    //deallocating memory

            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int N=100000,bit[]=new int[100005];
    static int query(int i)
    {
        i++;
        int sum=0;
        while(i>0)
        {
            sum+=bit[i];
            i-=i&-i;
        }
        return sum;
    }

    static void update(int i,int v)
    {
        i++;
        while(i<=N)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }
}
