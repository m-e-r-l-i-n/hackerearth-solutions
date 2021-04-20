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
            int n=Integer.parseInt(bu.readLine());
            int dp[][]=new int[2][3],i,j,a[]=new int[3],cur=1;
            for(i=1;i<=n;i++)
            {
                String s[]=bu.readLine().split(" ");
                for(j=0;j<3;j++) a[j]=Integer.parseInt(s[j]);
                dp[cur][0]=Math.min(dp[cur^1][1],dp[cur^1][2])+a[0];
                dp[cur][1]=Math.min(dp[cur^1][0],dp[cur^1][2])+a[1];
                dp[cur][2]=Math.min(dp[cur^1][0],dp[cur^1][1])+a[2];
                cur^=1;
            }
            int min=Integer.MAX_VALUE;
            for(i=0;i<3;i++) min=Math.min(min,dp[cur^1][i]);
            sb.append(min+"\n");
        }
        System.out.println(sb);
    }
}
