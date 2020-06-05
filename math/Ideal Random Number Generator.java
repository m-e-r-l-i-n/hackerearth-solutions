problem link-https://www.hackerearth.com/problem/algorithm/ideal-random-number-generator/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int a=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]),c=Integer.parseInt(s[2]);
        if(a+b<=c) {System.out.print("1/1"); return;}
        int deno=2*a*b,num=1;
        if(a>=c && b>=c) num=c*c;
        else if(c>=a && c>=b) num=2*a*c+2*b*c-a*a-b*b-c*c;
        else 
        {
        if(a>b) a=a^b^(b=a);
        num=2*c*a-a*a;
        }
        int g=gcd(num,deno);
        num/=g; deno/=g;
        System.out.print(num+"/"+deno+"\n");
    }

    static int gcd(int p,int q)
    {
        if(p<q) p=p^q^(q=p);
        while(q!=0)
        {
            int t=q;
            q=p%q;
            p=t;
        }
        return p;
    }
}
