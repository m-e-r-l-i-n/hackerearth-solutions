problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/jump-k-forward-250d464b/

import java.io.*;
import java.math.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]), k=Integer.parseInt(s[1]); int i,j;
        if(k==1) {System.out.println(1); return;}
        int c[]=new int[n],M=1000000007;
        c[0]=1;int a[]=new int[k];
        for(i=1;i<n;i++)
        for(j=1;j<=k;j++)	//dp algorithm-use this for such type of problems where sum of 1,1+2,1+2+3...are used
        if (i>=j) c[i]=(c[i]+c[i-j])%M;
        System.out.print(c[n-1]);
    }
    
}
