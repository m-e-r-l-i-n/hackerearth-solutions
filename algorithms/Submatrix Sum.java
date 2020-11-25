problem link-https://www.hackerearth.com/problem/algorithm/submatrix-sum/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main (String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        long sum=Long.parseLong(s[2]),dp[][]=new long[n+1][m+1];
        int i,j,a[][]=new int[n][m];
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m;j++)
            {
                a[i][j]=Integer.parseInt(s[j]);
                dp[i+1][j+1]=dp[i+1][j]+a[i][j];
            }
        }

        for(i=1;i<=m;i++)
        for(j=1;j<=n;j++)
        dp[j][i]+=dp[j-1][i];

        int l=1,r=Math.min(m,n),mid,ans[]={-1,-1,-1};
        while(l<=r)
        {
            mid=(l+r)/2;
            int p[]=possible(dp,mid,n,m,sum);
            if(p[0]!=-1)
            {
                ans[0]=mid;
                ans[1]=p[0];
                ans[2]=p[1];
                l=mid+1;
            }
            else r=mid-1;
        }
        sb.append(ans[0]+"\n");
        if(ans[0]!=-1) sb.append(ans[1]+" "+ans[2]);
        System.out.print(sb);
    }

    static int[] possible(long a[][],int k,int n,int m,long sum)
    {
        int ans[]={-1,-1},i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(i+k>n || j+k>m) break;
                long val=a[i+k][j+k]+a[i][j]-a[i+k][j]-a[i][j+k];
                if(val<=sum)
                {
                    ans[0]=i+1;
                    ans[1]=j+1;
                    break;
                }
            }
            if(ans[0]!=-1) break;
        }
        return ans;
    }
}
