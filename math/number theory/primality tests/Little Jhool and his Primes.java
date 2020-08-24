problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/little-jhool-and-his-primes/editorial/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long a=Long.parseLong(s[0]),d=Long.parseLong(s[1]);
            long m=Long.parseLong(bu.readLine());
            x=0;y=0;
            long g=eGcd(d,m);
            if(g!=1)  //corner cases
            {
                if(a%m==0) sb.append("0\n");
                else if((a+d)%m==0) sb.append("1\n");
                else sb.append("-1\n");
                continue;
            }

            /*
            we have to solve the eqn: a+dx=my
            dx-my=-a
            this is a linear Diophantine Equation in 2 variables and can be solved using Extended Euclidean Algorithm
            ax+by=c where a=d,b=m,c=-a [taking b=m and not -m will help us later]
             */

            a%=m;
            long x0=x*(-a/g);    
            x0%=m;
            if(x0>=0)    //we need x0>=0 because we cannot check for ap values<a
            sb.append(x0+"\n");
            else
            {
                long tem=m/g;  //get a higher value of x0 which is given by x=x0+k(b/g)
                long k=Math.abs(x0)/tem;
                x0+=k*tem;
                if(x0<0) x0+=tem;
                sb.append(x0+"\n");
            }
        }
        System.out.print(sb);
    }
    static long x,y;

    static long eGcd(long a,long b)
    {
        if(b==0)
        {
            x=1;
            y=0;
            return a;
        }
        else
        {
            long g=eGcd(b,a%b);
            long x1=x,y1=y;
            x=y1;
            y=x1-(a/b)*y1;
            return g;
        }
    }
}
