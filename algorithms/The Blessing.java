problem link-https://www.hackerearth.com/problem/algorithm/the-blessing-2/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long p=Long.parseLong(s[0]),m=Long.parseLong(s[1]);
            sb.append(2l*(p+m)+"\n");
        }
        System.out.print(sb);
    }
}
