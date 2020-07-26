problem link-https://www.hackerearth.com/problem/algorithm/divisors-1/?layout=old

import java.io.*;
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        long n=Long.parseLong(s[0]),a=Long.parseLong(s[1]),b=Long.parseLong(s[2]);
        long ans=n/a+n/b-n/lcm(a,b);
        System.out.print(ans);
    }
    
    static long lcm(long a,long b)
    {
        long t,x=a,y=b;
        while(y!=0)
        {
            t=y;
            y=x%y;
            x=t;
        }
        return a*b/x;
    }
}
