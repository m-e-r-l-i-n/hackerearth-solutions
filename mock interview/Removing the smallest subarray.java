import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),x=Integer.parseInt(s[1]),i,a[]=new int[n];
        s=bu.readLine().split(" ");
        long sum=0,pre[]=new long[n];
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            sum+=a[i];
        }
        if(sum%x==0) System.out.print("0");
        else if(sum<x) System.out.print(n);
        else
        {
            pre[0]=a[0]%x;
            for(i=1;i<n;i++)
            pre[i]=(pre[i-1]+a[i])%x;
            HashMap<Long,Integer> hm=new HashMap<>();
            long m=sum%x,min=Integer.MAX_VALUE;	//m is the excess part, we need to find a subarray with sum=m
            for(i=0;i<n;i++)
            {
                long r=(pre[i]-m+x)%x;
                if(hm.get(r)!=null) min=Math.min(min,i+1-hm.get(r));
                hm.put(pre[i],i+1);
            }
            if(min==Integer.MAX_VALUE) min=n;
            System.out.print(min);
        }
    }
}
