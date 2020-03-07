problem link-https://www.hackerearth.com/problem/algorithm/moving-d6f7a605/

import java.io.*;
import java.math.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine());
            if(n%2==0) sb.append("0\n");
            else
            {
                BigInteger b=new BigInteger("0");
                BigInteger x=new BigInteger("0");
                n=(n-1)/2-1;
                b=b.valueOf(2).modPow(x.valueOf(n),x.valueOf(1000000007));
                sb.append(b+"\n");
            }
        }
        System.out.print(sb);
    }
}
