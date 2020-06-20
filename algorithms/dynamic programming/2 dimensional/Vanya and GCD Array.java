problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/vanya-and-gcd-array/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,j,k,a[]=new int[n];
        long dp[][]=new long[500][101],M=1000000007;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            dp[i][a[i]]=1;
        }

        for(i=0;i<n;i++)
        for(j=i-1;j>=0;j--)
        if(a[i]>a[j])
        for(k=1;k<=100;k++)
        {
            int g=gcd(a[i],k);
            dp[i][g]=(dp[i][g]+dp[j][k])%M;
        }
        long ans=0;
        for(i=0;i<n;i++)
        ans=(ans+dp[i][1])%M;
        System.out.print(ans);
    }

    static int gcd(int a,int b)
    {
        int t;
        if(a<b) a=a^b^(b=a);
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
