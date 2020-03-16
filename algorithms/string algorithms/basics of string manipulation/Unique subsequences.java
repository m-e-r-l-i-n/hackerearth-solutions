problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/unique-subsequence-264057c9/

import java.io.*;
import java.util.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,l=1;
            String s=bu.readLine();
            char c[]=s.toCharArray();
            for(i=1;i<c.length;i++)
            if(c[i]!=c[i-1]) l++;
            sb.append(l+"\n");
        }
        System.out.print(sb);
    }
}
