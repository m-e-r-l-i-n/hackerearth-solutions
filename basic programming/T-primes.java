problem link-https://www.hackerearth.com/problem/algorithm/t-primes-c8a95cda-addb30e0/?utm_source=header&utm_medium=search&utm_campaign=he-search

import java.io.*;
import java.math.*;
 
class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int i; 
        for(i=0;i<n;i++)
        {
            long l=Long.parseLong(s[i]),j=0;
            double val=Math.sqrt(l);		//the logic is to check if the square root of the number is a prime or not
            
            if((val-Math.floor(val))!=0 || l==1) 		//if number=1 or square root doesnt exist, then the answer is no
            {sb.append("NO\n"); continue;}
            
            if(val==2.0 || val==3.0) 
            {sb.append("YES\n"); continue;}
            
            if(val%2==0 || val%3==0) 	//divisible by 2 or 3 but not their squares, get lost!!
            {sb.append("NO\n"); continue;}
            int t=0;
            for(j=5;j*j<=(long)val;j+=6)	//quick check through prime numbers
            if((long)val%j==0 || (long)val%(j+2)==0) {t=1;break;}
            if(t==0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
