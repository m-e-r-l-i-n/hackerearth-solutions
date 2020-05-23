problem link-https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/k-excess-1-be669e5a/?layout=old

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
            String s[]=bu.readLine().split(" ");
            long n=Long.parseLong(s[0]),k=Long.parseLong(s[1]),ans=n*(n+1)/2;
            while(k<=n)
            {
                n=n/k;
                ans-=k*(n*(n+1)/2);
                ans+=n*(n+1)/2;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
