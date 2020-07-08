problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/array-and-sums-6e5e7323/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int a[]=new int[n],i,c[]=new int[1001];
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                c[a[i]]++;
            }
            for(i=0;i<n;i++)
            {
                if(c[a[i]]>1) {sb.append("1 "); continue;}
                int j,k; boolean dp[][]=new boolean[a[i]+1][n+1];
                for(j=0;j<=n;j++)
                    dp[0][j]=true;
                for(j=1;j<=a[i];j++)
                for(k=1;k<=n;k++)
                {
                    dp[j][k]=dp[j][k-1];
                    if(k-1==i) continue;
                    if(j>=a[k-1]) dp[j][k]=dp[j][k] || dp[j-a[k-1]][k-1];
                }
                if(dp[a[i]][n]==false) sb.append("0 ");
                else sb.append("1 ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
