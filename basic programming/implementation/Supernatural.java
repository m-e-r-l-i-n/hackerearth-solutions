problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/supernatural-cac54bc7/description/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i,j,m,d,c=0;
        for(i=1;i<=1000000;i++)
        {
            j=i; m=1;
            boolean flag=true;
            while(j!=0)
            {
                d=j%10;
                j/=10;
                if(d<2) {flag=false; break;}
                m*=d;
            }
            if(m==n && flag) c++;
        }
        System.out.print(c);
    }
}
