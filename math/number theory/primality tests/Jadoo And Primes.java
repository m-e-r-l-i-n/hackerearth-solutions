problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/jadoo-and-primes/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,j,N=100000000,p[]=new int[N+1];
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=2*i;j<=N;j+=i)
        p[j]=1;
        
        long sum=0;
        ArrayList<Long> s=new ArrayList<>();
        for(i=2;i<=N;i++)
        if(p[i]==0)
        {
            sum+=i;
            s.add(sum);
        }

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(s.get(n-1)+"\n");
        }
        System.out.print(sb);
    }
}
