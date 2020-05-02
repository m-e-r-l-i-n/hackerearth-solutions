problem link-https://www.hackerearth.com/problem/algorithm/maximum-sum-8-29f3fc56/

import java.io.*;

class TestClass
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        long k=Long.parseLong(bu.readLine()),a=1,b=1,s=0;
        while(true)
        {
            s=a+b;
            if(s>k) break;
            a=b;
            b=s;
        }
        System.out.print(a+b);
    }
}
