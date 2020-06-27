problem link-https://www.hackerearth.com/problem/algorithm/and-path-in-binary-tree-62909fe5/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        int i,c[]=new int[100001];
        c[0]=c[1]=c[2]=0;
        for(i=3;i<=100000;i++)
        c[i]=c[(i-1)/2]+(i-i/2)/2;
        

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine().trim());
            sb.append(c[n]+"\n");
        }
        System.out.print(sb);
    }
}
