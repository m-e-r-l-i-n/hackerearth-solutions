problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/little-shino-and-prime-difference-38c91b0d/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int i,j,N=1000000,p[]=new int[N+1];
        p[0]=p[1]=1;
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=2*i;j<=N;j+=i)
        p[j]=1;

        int n=Integer.parseInt(bu.readLine()),k,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i]);
            if(p[k]==0)
            {
                min=Math.min(min,k);
                max=Math.max(max,k);
            }
        }
        if(max==Integer.MIN_VALUE) System.out.print("-1");
        else System.out.print(max-min);
    }
}
