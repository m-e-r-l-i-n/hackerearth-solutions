problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/recursive-function/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]);
        int ans=func(x,y)%1000;
        String an=Integer.toString(ans);
        int diff=3-an.length();
        for(ans=0;ans<diff;ans++)
        an='0'+an;
        System.out.print(an);
    }
    static int func(int x,int y)
    {
        if(x==0) return (y+1)%1000;
        if(y==0) return func(x-1,1)%1000;
        return func(x-1,func(x,y-1))%1000;
    }
}
