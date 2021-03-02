problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/xor-value-6dc9d9e4/

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
            int c[]=new int[63],i;
            long a;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a=Long.parseLong(s[i]);
                int j=0;
                while(a!=0)
                {
                    if(a%2==1) c[j]++;
                    a>>=1;
                    j++;
                }
            }

            long ans=0;
            for(i=0;i<63;i++)
            if(c[i]>n/2) ans|=1l<<i;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
