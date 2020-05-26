problem link-https://www.hackerearth.com/problem/algorithm/roy-and-matrix-sum-1/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i;
            long s=0;
            for(i=0;i<n/2;i++)
            {
                int c=n-i-1;
                s+=2l*c*(c+1)/2;
                s+=2l*i*(i+1)/2;
                //System.out.println(s);
            }
            if(n%2==1) 
            {
                int c=n/2;
                s+=2l*(c+1)*c/2;
            }
            sb.append(s+"\n");
        }
        System.out.print(sb);
    }
}
