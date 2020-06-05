problem link-https://www.hackerearth.com/problem/algorithm/who-wants-to-be-a-millionaire-7/?layout=old

import java.io.*;
import java.text.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        DecimalFormat df=new DecimalFormat("0.000000");
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            double n=Double.parseDouble(bu.readLine());
            sb.append(df.format((n-1)/n)+"\n");   
        }
        System.out.print(sb);
    }
}
