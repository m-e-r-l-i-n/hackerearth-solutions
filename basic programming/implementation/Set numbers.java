problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/set-numbers-bea74f5a/

import java.io.*;
import java.math.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int te=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(te-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            String s="";
            long t=0;int i=0,no=n;
            while(n>0)
            {
                int d=n%2;
                n=n/2;
                s=s+Integer.toString(d);
                t=t+(long)Math.pow(2,i); i++;
            }
            if(t>no)
            t=t-(long)Math.pow(2,i-1);
            sb.append(t+"\n");
        }
        System.out.print(sb);
    }
}
