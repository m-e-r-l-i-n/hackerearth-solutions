problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/interesting-game-3-4d4095c9/description/?layout=old

import java.io.*;
import java.math.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,c[]=new int[101],k;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i]);
            c[k]++;
        }
        int cn=0,max=0;
        for(i=1;i<=100;i++)
        {
            if(c[i]>0) cn++;
            max=Math.max(max,c[i]);
        }
        
        int m=(1<<(int)(Math.log(max)/Math.log(2)+1))-1;
        int a[]=new int[cn],j; 
        long dp[][]=new long[cn+1][m+1],M=1000000007;
        dp[0][0]=1; cn=0;
        for(i=1;i<=100;i++)
        if(c[i]>0) a[cn++]=c[i];
        for(i=1;i<=a.length;i++) 
        for(j=0;j<=m;j++) 
        dp[i][j]=(dp[i-1][j]+dp[i-1][j^a[i-1]])%M; 
        System.out.print(dp[a.length][0]);
    }
}
