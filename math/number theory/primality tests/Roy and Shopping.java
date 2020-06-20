problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/roy-and-shopping-20/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),N=1000000,i,j,p[]=new int[N+1];
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=i;j<=N;j+=i)
        if(p[j]==0) p[j]=i;
        StringBuilder sb=new StringBuilder();
        while(n-->0)
        {
            int k=Integer.parseInt(bu.readLine());
            sb.append(k-p[k]+"\n");
        }
        System.out.print(sb);
    }
}
