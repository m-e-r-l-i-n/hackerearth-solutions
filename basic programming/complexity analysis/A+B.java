problem link-https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/a-b-4/

import java.io.*;
import java.math.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String st=bu.readLine();
        while(st!=null)
        {
            String s[]=st.split(" ");
            BigInteger b=new BigInteger(s[0]);
            sb.append(b.add(new BigInteger(s[1]))+"\n");
            st=bu.readLine();
        }
        System.out.print(sb);
    }
}
