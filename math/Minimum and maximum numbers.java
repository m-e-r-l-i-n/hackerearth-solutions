problem link-https://www.hackerearth.com/problem/algorithm/minmax-2-7a1ffa10/?layout=old

import java.io.*;

class TestClass
{
    public static void main (String[] args) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine());
            long lar=1;
            while(n%lar==0) lar*=2;
            lar/=2;
            sb.append((n-lar+1)+" "+(n+lar-1)+"\n");
        }
        System.out.print(sb);
    }
}
