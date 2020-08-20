problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/airfares-dbef7f12/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String st[]=bu.readLine().split(" ");
        int p=Integer.parseInt(st[0]),s=Integer.parseInt(st[1]),t=Integer.parseInt(st[2]),h=Integer.parseInt(st[3]),x=Integer.parseInt(st[4]);
        int cost=0;
        while(x>0)
        {
            if(s<=t) cost+=h;
            else cost+=p;
            x--;
            s--;
        }
        System.out.print(cost);
    }
}
