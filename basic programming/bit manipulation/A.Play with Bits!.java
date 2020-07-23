problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/a-play-with-bits/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,c=0;
            long k;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                k=Long.parseLong(s[i]);
                while(k>0)
                {
                    if((k&1)==0) c++;
                    k>>=1;
                }
            }
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
