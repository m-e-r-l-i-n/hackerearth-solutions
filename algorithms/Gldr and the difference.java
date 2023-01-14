//problem link- https://www.hackerearth.com/problem/algorithm/gldr-and-the-difference-52b164ac/

import java.io.*;
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            sb.append(r-l+"\n");
        }
        System.out.print(sb);
    }
}
