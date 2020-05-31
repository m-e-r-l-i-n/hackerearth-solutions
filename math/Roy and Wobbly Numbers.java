problem link-https://www.hackerearth.com/problem/algorithm/roy-and-wobbly-numbers/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
            if(k>81) {sb.append("-1\n"); continue;}
            int i; String st="";
            int x=(k-1)/9,y=k%9; if(y==0) y=9;
            char a=(char)(x+1+'0'),b=' ';
            int cnt=0;
            for(i=0;i<=9;i++)
            {
                if(i==x+1) continue;
                cnt++;
                if(cnt==y) {b=(char)(i+'0'); break;}
            }
            for(i=0;i<n;i++)
            if(i%2==0) st+=a;
            else st+=b;
            sb.append(st+"\n");
        }
        System.out.print(sb);
    }
}
