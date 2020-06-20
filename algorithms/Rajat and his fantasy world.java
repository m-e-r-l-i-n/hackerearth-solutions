problem link-https://www.hackerearth.com/problem/algorithm/rajat-and-his-fantasy-world-8/description/?layout=old

import java.io.*;
import java.text.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]),n=Integer.parseInt(s[1]);
            String ans=String.format("%.10f",1.0/x);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
