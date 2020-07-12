problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/zrzr/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine());
            long i=5,ans=0;
            while(n/i>=1)
            {
                ans+=n/i;
                i*=5;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}


