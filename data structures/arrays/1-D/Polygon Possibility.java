problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/polygon-possible/

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),sum=0,i,a[]=new int[n];
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                sum+=a[i];
            }
            boolean f=true;
            for(i=0;i<n;i++)
            if(a[i]>=(sum-a[i])) {f=false; break;}
            if(f) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
    }
}
