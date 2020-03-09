problem link-https://www.hackerearth.com/problem/algorithm/the-ghost-open/

import java.io.*;
import java.util.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        // Write your code here
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            if(n==0) sb.append("0\n");
            else sb.append(n-1+"\n");
        }
        System.out.print(sb);
    }
}
