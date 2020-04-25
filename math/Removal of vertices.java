problem link-https://www.hackerearth.com/problem/algorithm/platypus-problem-cfaac646/

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
            long n=Long.parseLong(s[0]),k=Long.parseLong(s[1]);
            k%=n;
            long lar=1;
            while(lar<=n) lar*=2;
            lar/=2;
            long ans=2l*(n+k-lar)+1;
            ans%=n;
            if(ans==0) ans=n;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
