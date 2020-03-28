problem link-https://www.hackerearth.com/problem/algorithm/annoying-chemistry-f5fb9556/

import java.io.*;
class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]),p=Integer.parseInt(s[2]), q=Integer.parseInt(s[3]);

        /*
        b1Cx + b2Hy -> b3CpHq
        
        b1.x=b3.p => b3=(b1.x)/p...(i)
        b2.y=b3.q => b3=(b2.y)/q...(ii)
        from (i) and (ii)
        b1.xq=b2.py
        => b1/b2=py/xq
        => b1=py, b2=xq
        
        putting the value of b1 or b2 in (i) or (ii) respectively, we get
        b3=py.x/p=xy
        therefore b1=py, b2=qx, b3=xy
        now we need to reduce them so that they are coprime 
        */
        
        int b1=p*y,b2=q*x,b3=x*y,f=0,i;
        if(b1>b2 && b1>b3) f=b1;
        else if(b2>b3 && b2>b1) f=b2;
        else f=b3;
        
        for(i=2;i<=f/2;i++)
        if(b1%i==0 && b2%i==0 && b3%i==0)
        while(b1%i==0 && b2%i==0 && b3%i==0)
        {b1=b1/i; b2=b2/i; b3=b3/i;} 
        System.out.print(b1+" "+b2+" "+b3);
    }
}
