problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/little-jhool-and-too-many-products-2804a098/

import java.io.*;
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String st[]=bu.readLine().trim().split(" ");
            long a=Long.parseLong(st[0]), s=Long.parseLong(st[1]);
            if(a<s) {sb.append("0\n"); continue;}
            if(s>a/2) {sb.append("1\n"); continue;}
            long dp[][]=new long[(int)a+2][(int)a+2];
            dp[0][(int)a+1]=1;   
            for(int i=(int)a;i>=s;i--)   //numbers greater than a
            for(int j=0;j<=(int)a;j++)   //sum
            {
                dp[j][i]=dp[j][i+1]%1000000009;    //initializing dp[j][i] to number of ways to get sum using numbers >=i+1
                if(j-i>=0l) dp[j][i]=(dp[j][i]+dp[j-i][i])%1000000009;    //if j>i
            }
            sb.append(dp[(int)a][(int)s]+"\n");
  
        }
        System.out.print(sb);
    }
}
