problem link-https://www.hackerearth.com/problem/algorithm/smallest-subarray-6a9abf79/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),l=0,mins=0,mine=n,i;
        int a[]=new int[n],x=Integer.parseInt(bu.readLine()),sum=0;
        if(n==1) {System.out.println(" "); return;}
        else 
        for(i=1;i<=n;i++)
        a[i-1]=Integer.parseInt(s[i]);
        int e=0,st=0;
        while(e<n)
        {
            while(sum<=x && e<n)
            sum+=a[e++];
            while(sum>x && st<e)
            {
                if(e-st<mine-mins) {mine=e; mins=st;}
                sum-=a[st++];
            }
        }
        for(i=mins;i<mine;i++)
        System.out.print(a[i]+" ");
    }
}
