problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/samu-and-shooting-game/description/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]),n=Integer.parseInt(s[2]),w=Integer.parseInt(s[3]),i,j,c=1,p=0;
            double p1=Integer.parseInt(s[4])/100.0,p2=Integer.parseInt(s[5])/100.0;
            double dp[][]=new double[2][w+1];
            for(i=1;i<=n;i++)
            {
                for(j=0;j<=w;j++)
                {
                    double a=p1,b=p2;
                    if(j+x<w) a*=dp[p][j+x];
                    if(j+y<w) b*=dp[p][j+y];
                    dp[c][j]=Math.max(a+(1-p1)*dp[p][j],b+(1-p2)*dp[p][j]);
                }
                c^=1;
                p^=1;
            }
            System.out.printf("%.6f\n",dp[p][0]*100);
        }
    }
}
