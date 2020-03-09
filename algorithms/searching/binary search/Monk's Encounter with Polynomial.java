problem link-https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monks-encounter-with-polynomial/

import java.io.*;
import java.util.*;
import java.math.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long a=Long.parseLong(s[0]),b=Long.parseLong(s[1]),c=Long.parseLong(s[2]),k=Long.parseLong(s[3]);
            c-=k;
            if(b*b-4*a*c<=0 || c>=0)
            {sb.append("0\n"); continue;}
            int ans=(int)Math.ceil((-b+Math.sqrt(b*b-4*a*c))/(2*a));
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
