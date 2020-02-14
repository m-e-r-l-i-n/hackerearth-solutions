problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/distribute-chocolates-70c2c2ab/

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long n=Long.parseLong(s[1]),c=Long.parseLong(s[0]);
            if(c<(n*(n+1)/2))
            {sb.append(c+"\n"); continue;}
            long k=c/n-(n-1)/2,fin=n*k+n*(n-1)/2;
            if(fin>c)   fin-=n;
            sb.append((c-fin)+"\n");
        }
        System.out.println(sb);
    }
}
