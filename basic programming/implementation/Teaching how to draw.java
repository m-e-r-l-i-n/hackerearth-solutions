problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/how-many-buildings-you-can-make-1/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,j,c=0;
            for(i=1;i*i<=n;i++)
            for(j=i;j*i<=n;j++)
            c++;
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
