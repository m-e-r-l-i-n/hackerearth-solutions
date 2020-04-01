problem link-https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/split-house-547be0e9/

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i;
        String s=bu.readLine();
        if(s.contains("HH")) {System.out.print("NO"); return;}
        StringBuilder sb=new StringBuilder();
        sb.append("YES\n");
        for(i=0;i<s.length();i++)
        if(s.charAt(i)=='.') sb.append("B");
        else sb.append(s.charAt(i));
        System.out.println(sb);
    }
}
