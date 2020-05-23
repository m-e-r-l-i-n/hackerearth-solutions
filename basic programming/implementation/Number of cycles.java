problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/cycle-count-0644f309/?layout=old

import java.io.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(q-->0)
        {
            long n=Long.parseLong(bu.readLine());
            n=n*(n-1)+1;
            sb.append(n+"\n");
        }
        System.out.print(sb);
    }
}
