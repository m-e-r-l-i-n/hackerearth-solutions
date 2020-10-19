problem link-https://www.hackerearth.com/problem/algorithm/nikhil-and-matrice-1/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main (String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int q=Integer.parseInt(bu.readLine());
        while(q-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int l=0,r=n-1,t=0,b=n-1,i,a[][]=new int[n][n],j=1;
            while(empty(a,n))
            {
                for(i=l;i<=r;i++)
                a[t][i]=j++;
                t++;
                for(i=t;i<=b;i++)
                a[i][r]=j++;
                r--;
                for(i=r;i>=l;i--)
                a[b][i]=j++;
                b--;
                for(i=b;i>=t;i--)
                a[i][l]=j++;
                l++;
            }
            for(i=0;i<n;i++)
            {
                for(l=0;l<n;l++)
                sb.append(a[i][l]);
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean empty(int a[][],int n)
    {
        int i,j;
        for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        if(a[i][j]==0) return true;
        return false;
    }
}
