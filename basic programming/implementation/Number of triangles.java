problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/number-of-triangles-6ac88eb2/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),a=Integer.parseInt(s[1]),b=Integer.parseInt(s[2]);
            long ans=0;
            if(a>b) a=a^b^(b=a);
            if(b-a==1 || (b==n && a==1)) ans=1l*(n-4)*(n-4);
            else ans=1l*(n-5)*(n-4)+2;
            if(b-a==2 || a+(n-b)==2) ans--;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
