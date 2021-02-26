problem link-https://www.hackerearth.com/problem/algorithm/tree-of-many-leaves-c3413985/

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
            int n=Integer.parseInt(bu.readLine()),i;
            ArrayList<Integer> a=new ArrayList<>();
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            a.add(Integer.parseInt(s[i]));

            while(a.size()>1)
            {
                ArrayList<Integer> te=new ArrayList<>();
                for(i=0;i<a.size();i+=2)
                {
                    int x=a.get(i);
                    if(i+1<a.size()) x^=a.get(i+1);
                    te.add(x);
                }
                a=te;
            }
            sb.append(a.get(0)+"\n");
        }
        System.out.println(sb);
    }
}
