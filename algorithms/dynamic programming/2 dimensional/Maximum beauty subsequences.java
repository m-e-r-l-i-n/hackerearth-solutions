problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/maximum-beauty-subsequence-764b18e3/description/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),c[][]=new int[26][26],i,mp[][]=new int[26][26];
        char s[]=bu.readLine().toCharArray();
        int m=Integer.parseInt(bu.readLine());
        while(m-->0)
        {
            String st[]=bu.readLine().split(" ");
            int l=st[0].charAt(0)-'a',r=st[1].charAt(0)-'a',x=Integer.parseInt(st[2]);
            mp[l][r]+=x;
        }
        int used[]=new int[26];
        used[s[0]-'a']=1;
        long dp[][]=new long[n][26],sum=0;
        for(i=1;i<n;i++) 
        {
            int j;
            for(j=0;j<26;j++) 
            if(used[j]==1) dp[i][s[i]-'a'] = Math.max(dp[i-1][j]+mp[j][s[i]-'a'], dp[i][s[i]-'a']);
            
            for(j=0;j<26;j++)
            if(s[i]-'a'!=j) dp[i][j]=dp[i-1][j];
            used[s[i]-'a']=1;
        }
        for(i=0;i<26;i++)
        if(used[i]==1)sum=Math.max(sum,dp[n-1][i]);
        System.out.print(sum);
    }
}
