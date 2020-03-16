problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/roys-life-cycle/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,x=0,y=0,len=0;
        for(i=0;i<n;i++)
        {
            String s=bu.readLine();
            int j,code=0,loclen=0;
            for(j=0;j<s.length();j++)
            {
                char c=s.charAt(j);
                if(c=='C')
                {len++;loclen++;}
                else
                {
                    if(loclen>code) code=loclen;
                    if(len>y) y=len;
                    len=0; loclen=0;
                }
            }
            if(len>y) y=len;
            if(loclen>code) code=loclen;
            if(code>x) x=code;
        }
        System.out.print(x+" "+y);
    }
}
