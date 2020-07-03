problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/maximum-and/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long a=Long.parseLong(s[0]),b=Long.parseLong(s[1]);
            if(b%2==0) b--;
            if(b==a) sb.append((b&(b+1))+"\n");
            else sb.append((b&(b-1))+"\n");
        }
        System.out.print(sb);
    }
}
