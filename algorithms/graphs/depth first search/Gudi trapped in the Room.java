problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/gudi-trapped-in-the-room-july-easy/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s=bu.readLine();
            String st[]=bu.readLine().split(" ");
            int a=Integer.parseInt(st[0]),h=Integer.parseInt(st[1]),min=Integer.MAX_VALUE,n=s.length();
            boolean vis[]=new boolean[1000000];
            String mins="";
            
            Queue<String> q=new LinkedList<>();
            q.add(s);
            int eq=Integer.parseInt(s);
            vis[eq]=true;
            while(!q.isEmpty())
            {
                s=q.poll();
                eq=Integer.parseInt(s);
                if(eq<min)
                {min=eq;mins=s;}
                
                String temp=replace(s,a,n);
                eq=Integer.parseInt(temp);
                if(!vis[eq])
                {vis[eq]=true;q.add(temp);}
                temp=move(s,h,n);
                
                eq=Integer.parseInt(temp);
                if(!vis[eq])
                {vis[eq]=true;q.add(temp);}
            }
            sb.append(mins+"\n");
        }
        System.out.print(sb);
    }

    static String replace(String s, int a, int n)
    {
        char c[]=s.toCharArray();
        for(int i=1;i<n;i=i+2)
        {
            int num=(int)(c[i]-'0');
            num=num+a;
            num=num%10;
            c[i]=(char)(num+'0');
        }
        return new String(c);
    }
    
    static String move(String s,int h,int n)
    {
        char temp[]=new char[n];
        h=h%n;
        for(int i=0;i<n;i++)
        temp[(i+h)%n]=s.charAt(i);
        return new String(temp);
    }
}
