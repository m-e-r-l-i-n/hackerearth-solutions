problem link-https://www.hackerearth.com/problem/algorithm/array-reverse-24921897/?layout=old

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
            char s[]=bu.readLine().toCharArray();
            int i; boolean a=s[0]=='1',b=s[1]=='1',c=s[2]=='1',d=s[3]=='1';
            boolean ans=a&b;
            ans|=!c;
            ans&=d;
            ans=!ans;
            if(ans) sb.append("True\n");
            else sb.append("False\n");
        }
        System.out.print(sb);
    }
}
