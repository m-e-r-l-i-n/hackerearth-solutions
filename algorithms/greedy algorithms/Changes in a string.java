problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/ab-string-5f6b213a/

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            char s[]=bu.readLine().toCharArray();
            int i,al[]=new int[n],br[]=new int[n],c=0;
            for(i=0;i<n;i++)
            {if(s[i]=='A') c++;
            al[i]=c;}
            c=0;
            for(i=n-1;i>=0;i--)
            {if(s[i]=='B') c++;
            br[i]=c;}
            int ch=0,min=10000000;
            for(i=0;i<n;i++)
            {
                ch=n-(al[i]+br[i]);
                if(ch<min) min=ch;
            }
            sb.append(min+"\n");
        }
        System.out.print(sb);
    }
}
