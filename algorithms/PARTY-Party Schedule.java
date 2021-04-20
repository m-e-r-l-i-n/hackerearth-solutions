import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int k=Integer.parseInt(s[0]),n=Integer.parseInt(s[1]);
        while(k!=0)
        {
            int dp[][]=new int[n+1][k+1];
            int i,j;
            for(i=1;i<=n;i++)
            {
                s=bu.readLine().split(" ");
                int v=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]);
                for(j=0;j<=k;j++)
                if(j<v) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v]+b);
            }

            int ans=-1,ansp=-1;
            for(i=0;i<=k;i++)
            if(dp[n][i]>ans)
            {
                ans=dp[n][i];
                ansp=i;
            }
            sb.append(ansp+" "+ans+"\n");
            //bu.readLine();
            s=bu.readLine().split(" ");
            k=Integer.parseInt(s[0]); n=Integer.parseInt(s[1]);
        }
        System.out.println(sb);
    }
}
