problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/akash-and-diagnol-moves-dfc4f00f/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]);
            if(x<0 || y<0 || x<y) {sb.append("-1\n"); continue;}
            sb.append(y+(x-y)+"\n");
        }
        System.out.print(sb);
    }
}
