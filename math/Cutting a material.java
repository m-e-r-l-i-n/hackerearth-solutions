problem link-https://www.hackerearth.com/problem/algorithm/pizza-cutting-2e11a081/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine());
            /*f(n)=n+f(n-1)
            => f(n)=1/2(n^2+n+2)
             */
            n=n*n+n+2;
            n/=2;
            sb.append(n+"\n");
        }
        System.out.print(sb);
    }
}
