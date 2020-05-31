problem link-https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/little-jhool-and-the-magical-jewels/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s=bu.readLine();
            int i,cr=0,cu=0,cb=0,cy=0;
            for(i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if(ch=='r') cr++;
                if(ch=='u') cu++;
                if(ch=='b') cb++;
                if(ch=='y') cy++;
            }
            sb.append(Math.min(Math.min(cr,cy),Math.min(cu,cb))+"\n");
        }
        System.out.print(sb);
    }
}
