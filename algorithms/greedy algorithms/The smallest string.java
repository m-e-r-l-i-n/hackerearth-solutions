problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/smallest-string-2-e150a408/

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
            char c[]=bu.readLine().trim().toCharArray();
            int i;
            for(i=0;i<n;i++)
            {
                int add='z'-c[i]+1;
                add%=26;
                if(add<=k)
                {
                    c[i]='a';
                    k-=add;
                }
            }
            k%=26;
            while(k>0)
            {
                c[n-1]++;
                k--;
                if(c[n-1]>'z') c[n-1]='a';
            }
            sb.append(new String(c)+"\n");
        }
        System.out.print(sb);
    }
}
