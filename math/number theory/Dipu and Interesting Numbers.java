problem link-https://www.hackerearth.com/problem/algorithm/dipu-and-interesting-numbers-2/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long a=Long.parseLong(s[0]),b=Long.parseLong(s[1]);
            //question is reduced to number of squares in a range
            long l=(long)Math.sqrt(a-1),r=(long)Math.sqrt(b);
            long ans=r-l;
            if(l*l>=a) ans++;
            if(r*r>b) ans--;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
