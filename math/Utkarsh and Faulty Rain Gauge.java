problem link-https://www.hackerearth.com/problem/algorithm/utkarsh-and-faulty-rain-gauge-february-easy-1/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        double ans=1;
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            ans*=1.5*n*(n+1)/r/(2*n+1);
        }
        System.out.printf("%.4f",ans);
    }
}
