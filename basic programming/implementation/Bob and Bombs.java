problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/bob-and-bombs-cake-walk/?layout=old

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
            int n=s.length,i; boolean b[]=new boolean[n];
            for(i=0;i<n;i++)
            if(s[i]=='B')
            {
                if(i-1>=0 && s[i-1]!='B') b[i-1]=true;
                if(i-2>=0 && s[i-2]!='B') b[i-2]=true;
                if(i+1<n && s[i+1]!='B') b[i+1]=true;
                if(i+2<n && s[i+2]!='B') b[i+2]=true;
            }
            int c=0;
            for(i=0;i<n;i++)
            if(b[i]) c++;
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
