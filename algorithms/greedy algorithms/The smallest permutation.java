problem lin-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/smallest-permutation-5584d662/

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
            int i,a[]=new int[n];
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);

            boolean mov=false;
            for(i=0;i<n;i++)
            if(a[i]!=i+1)
            {
                int j=i;
                while(a[j]!=i+1) j++;
                a[j]=a[i];
                a[i]=i+1;
                mov=true;
                break;
            }

            if(!mov) a[n-1]=a[n-1]^a[n-2]^(a[n-2]=a[n-1]);
            for(i=0;i<n;i++) sb.append(a[i]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
