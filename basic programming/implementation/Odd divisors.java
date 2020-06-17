problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/odd-divisors-1-4939f17d/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long n=Long.parseLong(s[0]),m=Long.parseLong(s[1]),ans=0;
            //sum=k^2+sum(1 2 3...floor(n/2)) where k is the number of odd numbers between 1-n
            sb.append(sum(n,m)+"\n");
        }
        System.out.print(sb);
    }

    static long sum(long n,long m)
    {
        if(n==0) return 0;
        if(n%2==1) return (square((n+1)/2,m)+sum(n/2,m))%m;
        else return (square(n/2,m)+sum(n/2,m))%m;
    }

    static long square(long n,long m)
    {
        n%=m;
        n=n*n;
        n%=m;
        return n;
    }
}
