//problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/erasing-the-array-7e9e0400/

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
            int n=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            int i,ans=1,a,p=Integer.parseInt(s[0]);
            for(i=1;i<n;i++)
            {
                a=Integer.parseInt(s[i]);
                if(a<p) ans++;
                p=a;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
