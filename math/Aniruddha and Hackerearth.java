problem link-https://www.hackerearth.com/problem/algorithm/aniruddha-and-hackerearth/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,N=1000000;
        long v[]=new long[N+1],M=1000000007,fiba=1,fibb=1;
        for(i=1;i<=N;i++)
        {
            long cur=(fiba+fibb)%M;
            v[i]=(v[i-1]+cur)%M;
            fiba=fibb;
            fibb=cur;
        }
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(v[n]+"\n");
        }
        System.out.print(sb);
    }
}
