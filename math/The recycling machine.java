problem link-https://www.hackerearth.com/problem/algorithm/the-recycling-machine-864e8433/?layout=old

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
            long n=Long.parseLong(s[0]),k=Long.parseLong(s[1]),b=0;
            while(n>=k)
            {
                long te=n%k;
                b+=n/k;
                n/=k;
                n+=te;
            }
            sb.append(b+"\n");
        }
        System.out.print(sb);
    }
}
