//problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/range-minimum-query/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
        int i,x; st=new int[4*n];
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            x=Integer.parseInt(s[i]);
            update(0,n-1,i,x,0);
        }

        while(q-->0)
        {
            s=bu.readLine().split(" ");
            if(s[0].charAt(0)=='u') update(0,n-1,Integer.parseInt(s[1])-1,Integer.parseInt(s[2]),0);
            else sb.append(query(0,n-1,Integer.parseInt(s[1])-1,Integer.parseInt(s[2])-1,0)+"\n");
        }
        System.out.print(sb);
    }

    static int st[];
    static void update(int ss,int se,int i,int v,int n)
    {
        if(i<ss || i>se) return;
        if(ss==se)
        {
            st[n]=v;
            return;
        }
        int m=ss+(se-ss)/2;
        if(i>=ss && i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=Math.min(st[2*n+1],st[2*n+2]);
    }

    static int query(int ss,int se,int l,int r,int n)
    {
        if(l<=ss && r>=se) return st[n];
        if(se<l || ss>r) return Integer.MAX_VALUE;

        int m=ss+(se-ss)/2;
        return Math.min(query(ss,m,l,r,2*n+1),query(m+1,se,l,r,2*n+2));
    }

}
