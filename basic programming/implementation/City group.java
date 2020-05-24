problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/city-group-3/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        int i,a[]=new int[n+1],j,t;
        for(i=0;i<k;i++)
        {
            s=bu.readLine().split(" ");
            t=Integer.parseInt(s[0]);
            for(j=0;j<t;j++)
            a[Integer.parseInt(s[j+1])-1]=i;
        }
        int q=Integer.parseInt(bu.readLine());
        for(i=0;i<q;i++)
        {
            s=bu.readLine().split(" ");
            j=Integer.parseInt(s[0])-1; t=Integer.parseInt(s[1])-1;
            int ans=Math.min(Math.abs(a[j]-a[t]),k-Math.abs(a[j]-a[t]));
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
