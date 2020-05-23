problem link-https://www.hackerearth.com/problem/algorithm/powerful-of-factorial-cb263e5b/?layout=old

import java.io.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        long x=Long.parseLong(s[0]),n=Long.parseLong(s[1]),ans=1;
        int fac[]={1,1,2,6,4};	//0!=1 1!=1 2 6 24(we need only the 4)
        if(n<5)
        {
            x=x%10;
            ans=(long)Math.pow(x,fac[(int)n])%10;
        } 
        System.out.print(ans);
    }
}
