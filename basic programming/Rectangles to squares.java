problem link-https://www.hackerearth.com/problem/algorithm/rectange-to-squares/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        long x=Long.parseLong(s[0]),y=Long.parseLong(s[1]);
        if(x<y) x=x^y^(y=x);
        while(true)
        {
            if(y==0) break;
            long t=y;
            y=x%y;
            x=t;
        }
        if(x==1)
        System.out.print("No");
        else
        System.out.print("Yes");
    }
}
