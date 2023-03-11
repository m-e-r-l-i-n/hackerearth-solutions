//problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/rook-attack-b899b655/

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);

        int i,j,a[][]=new int[n+1][m+1];
        long r[][]=new long[n+1][m+1],c[][]=new long[n+1][m+1];
        for(i=1;i<=n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=1;j<=m;j++)
            {
                a[i][j]=Integer.parseInt(s[j-1]);
                r[i][j]+=r[i][j-1]+a[i][j];
                c[i][j]+=c[i-1][j]+a[i][j];
            }
        }

        int ans[]={1,1};
        long mx=0;
        for(i=1;i<=n;i++)
        for(j=1;j<=m;j++)
        {
            long here=r[i][m]-r[i][j]+r[i][j-1];
            here+=c[n][j]-c[i][j]+c[i-1][j];
            if(here>mx)
            {
                mx=here;
                ans[0]=i;
                ans[1]=j;
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
}
