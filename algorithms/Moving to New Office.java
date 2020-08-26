problem link-https://www.hackerearth.com/problem/algorithm/moving-to-new-office-dd532d09/description/?layout=old

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
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]);
            int i,n=Integer.parseInt(bu.readLine());
            int a[]=new int[n],m[][]=new int[n][n];
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                Arrays.fill(m[i],-1);
            }
            mincost(x,y,a,0,n-1,m);
            sb.append(m[0][n-1]+"\n");
        }
        System.out.print(sb);
    }

    static int mincost(int x,int y,int a[],int s,int e,int m[][])
    {
        if(m[s][e]!=-1) return m[s][e];
        if(e-s<=1)
        {
            m[s][e]=0;
            return 0;
        }
        else
        {
            int min=Integer.MAX_VALUE,i,j;
            for(i=s+1;i<e;i++)
            {
                int c=x*(a[i]-a[s])+y*(a[e]-a[i])+mincost(x,y,a,s,i,m)+mincost(x,y,a,i,e,m);
                min=Math.min(min,c);
            }
            m[s][e]=min;
            return min;
        }
    }
}
