problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/contest-bw-sonika-and-rishika-216a7b6d/?layout=old

import java.io.*;

class TestClass
{
    public static void main (String[] args) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long a=Long.parseLong(s[0]),b=Long.parseLong(s[1]),n=Long.parseLong(s[2])-1;
            long max=xor(n%3,a,b);
            max=Math.max(max,xnor(n%3,a,b));
            sb.append(max+"\n");
        }
        System.out.print(sb);
    }

    static long xor(long n,long a,long b)
    {
        if(n==0) return a;
        else if(n==1) return b;
        else return a^b;
    }

    static long xnor(long n,long a,long b)
    {
        if(n==0) return a;
        else if(n==1) return b;
        else return calxor(Math.max(a,b),Math.min(a,b));
    }

    static long calxor(long a,long b)
    {
        if(a==0) return b^1;
        long i=a;
        a|=a>>1;
        a|=a>>2;
        a|=a>>4;
        a|=a>>8;
        a|=a>>16;
        a|=a>>32;
        a|=a>>64;
        return (a^i)^b;
    }
}
