problem link-https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/yet-another-valentines-proposal/

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
        int i,j,c[][]=new int[n+1][26];
        char str[]=bu.readLine().toCharArray();
        for(i=1;i<=n;i++)
        {
            c[i][str[i-1]-'a']++;
            for(j=0;j<26;j++)
            c[i][j]+=c[i-1][j];
        }
        
        StringBuilder sb=new StringBuilder();
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            char ans[]=new char[26];
            for(i=0;i<26;i++)
            ans[i]=(char)((c[r][i]-c[l-1][i])%26+'a');
            int len=0,lps[]=new int[26]; i=1; 
            while(i<26) //KMP algorithm
            {
                if(ans[i]==ans[len]) lps[i++]=++len;
                else if(len!=0) len=lps[len-1];
                else {lps[i++]=0;}
            }
            if(lps[25]==0) sb.append("None");
            else
            {
                for(i=0;i<lps[25];i++)
                sb.append(ans[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
