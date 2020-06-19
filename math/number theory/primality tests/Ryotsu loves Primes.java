problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/ryotsu-love-primes/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int N=1000000,p[]=new int[N+1],i,j;
        p[0]=p[1]=1;
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=2*i;j<=N;j+=i) p[j]=1;
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]); long sum=0;
            j=0;
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                int x=Integer.parseInt(s[i]);
                if(p[x]==0) j++;
                if(j==k) {sum+=x; j=0;}
            }
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}
