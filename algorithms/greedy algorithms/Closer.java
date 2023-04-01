//https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/closer-142dd040/

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        s=bu.readLine().split(" ");

        int i,a[]=new int[n+1];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            pq.add(a[i]);
        }
        for(i=1;i<=n;i++) a[i]=pq.poll();
        a[0]=0;

        long sum[]=new long[n+1];
        for(i=1;i<=n;i++)
        {
            sum[i]=a[i];
            sum[i]+=sum[i-1];
        }

        long ans=Long.MAX_VALUE;
        int j=1;
        for(i=a[1];i<=a[n];i++)
        {
            while(j<=n && a[j]<=i) j++;

            int l=i,r=i+k;
            long mv1=1l*l*(j-1)-sum[j-1];  //this to take all to l

            int x=smallest(a,r),hi=n-x+1;   //this should be brought down to r
            long mv2=sum[n]-sum[x-1]-1l*hi*r;

            long stretch1=1l*(x-1)*r-sum[x-1],stretch2=sum[n]-sum[j-1]-1l*(n-j+1)*l;
            //System.out.println(i+" "+j+" "+mv1+" "+stretch1+" "+x+" "+mv2+" "+stretch2);
            if(mv1>mv2)
            {
                mv1=mv1^mv2^(mv2=mv1);
                stretch1=stretch1^stretch2^(stretch2=stretch1);
            }

            if(stretch1<mv2) continue;
            ans=Math.min(ans,mv2);
        }
        System.out.println(ans);
    }

    static int smallest(int a[],int k)
    {
        int l=0,r=a.length-1,mid,ans=r+1;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a[mid]>k)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
