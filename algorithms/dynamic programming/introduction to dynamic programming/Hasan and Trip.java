problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/hasan-and-trip/?layout=old

import java.io.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,a[][]=new int[n][3],j;
        double dp[]=new double[n];
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            a[i][0]=Integer.parseInt(s[0]);
            a[i][1]=Integer.parseInt(s[1]);
            a[i][2]=Integer.parseInt(s[2]);
            dp[i]=Long.MIN_VALUE;
        }
        dp[0]=a[0][2];
        for(i=1;i<n;i++)
        {
            for(j=0;j<i;j++)
            dp[i]=Math.max(dp[i],dp[j]-Math.sqrt(1l*(a[j][0]-a[i][0])*(a[j][0]-a[i][0])+
            1l*(a[j][1]-a[i][1])*(a[j][1]-a[i][1])));
            dp[i]+=a[i][2];
        }
        System.out.format("%.6f",dp[n-1]);
    }
}
