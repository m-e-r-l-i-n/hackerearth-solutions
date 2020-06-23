problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/xsquare-and-two-strings-1/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String a=bu.readLine();
            String b=bu.readLine();
            int ca[]=new int[26],cb[]=new int[26],i;
            for(i=0;i<a.length();i++)
            ca[a.charAt(i)-'a']++;
            for(i=0;i<b.length();i++)
            cb[b.charAt(i)-'a']++;
            boolean flag=false;
            for(i=0;i<26;i++)
            if(ca[i]>0 && cb[i]>0) {flag=true; break;}
            if(flag) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
    }
}
