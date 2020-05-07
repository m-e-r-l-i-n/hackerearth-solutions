problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/equal-bitwise-operations-33fa5acd/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),k,i;
        String s[]=bu.readLine().split(" ");
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i]);
            if(hm.get(k)==null) hm.put(k,1);
            else hm.put(k,hm.get(k)+1);
        }
        long c=0,M=1000000007;
        //&=|=^ only for same elements taken in odd numbers=2^(n-1)
        //however for 0, the answer is 2^n-1 because 0 will yield same value for all cases
        for(int x:hm.keySet())
        {
            if(x==0)    //this is the most vital case 
            {
                k=hm.get(x);
                c=c%M+power(k)-1;
            }
            else
            {
                k=hm.get(x)-1;
                c=c%M+power(k);
            }
            c%=M;
        }
        System.out.print(c);
    }

    static long power(int x)
    {
        long ans=1,b=2l,M=1000000007;
        while(x!=0)
        {
            if(x%2==1) ans=(ans*b)%M;
            b=(b*b)%M;
            x/=2;
        }
        return ans%M;
    }
}
