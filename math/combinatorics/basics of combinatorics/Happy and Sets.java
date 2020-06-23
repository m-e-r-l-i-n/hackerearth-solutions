problem link-https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/happy-and-sets/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,k;
        String s[]=bu.readLine().split(" ");
        long ans=1,M=1000000007;
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i])+1;
            ans=(ans*k)%M;
        }
        ans-=1;
        System.out.print(ans);
    }
}
