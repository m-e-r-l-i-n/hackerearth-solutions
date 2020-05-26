problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/practice-problems/algorithm/great-arjit-and-numbers/?layout=old

import java.io.*;
import java.math.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i;
            long M=1000000007;
            String s[]=bu.readLine().split(" ");
            long a[]=new long[n-1],x=Long.parseLong(s[0]),k;
            for(i=1;i<n;i++)
            {
                k=Long.parseLong(s[i]);
                a[i-1]=(k*modulus(x,M-2,M))%M;
                x=k;
            }
            long sum=0;
            for(i=0;i<a.length;i++)
            sum=(sum+a[i]*(a[i]+1)/2)%M;
            sum=(sum*(sum+1))/2%M;
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
    
    static long modulus(long x, long n, long M)
    {
        long res=1;
        while(n!=0)
        {
            if(n%2==1) res=(res*x)%M;
            n>>=1;
            x=(x*x)%M;
        }
        return res;
    } 
}
