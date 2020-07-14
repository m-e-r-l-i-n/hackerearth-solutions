problem link-https://www.hackerearth.com/problem/algorithm/roots/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,ans=0,a,b,c;
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            a=Integer.parseInt(s[0]); b=Integer.parseInt(s[1]); c=Integer.parseInt(s[2]);
            int v=b*b-4*a*c;
            if(v>=0) ans++;
        }
        System.out.print(ans);
    }
}
