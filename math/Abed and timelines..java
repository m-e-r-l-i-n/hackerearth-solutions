problem link-https://www.hackerearth.com/problem/algorithm/abed-and-timelines/?layout=old

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
            s=bu.readLine().split(" ");
            int x1=Integer.parseInt(s[0]),y1=Integer.parseInt(s[1]);
            s=bu.readLine().split(" ");
            int x2=Integer.parseInt(s[0]),y2=Integer.parseInt(s[1]);
            int cost=Integer.parseInt(bu.readLine());
            int minx=Math.min(Math.abs(x1-x2),n-Math.abs(x1-x2));
            int miny=Math.min(Math.abs(y1-y2),m-Math.abs(y1-y2));
            sb.append(cost*(minx+miny)+"\n");
            if(cost*(minx+miny)<=1000) sb.append("You saved the group.\n");
            else sb.append("Let go of the group.\n");
        }
        System.out.print(sb);
    }
}
