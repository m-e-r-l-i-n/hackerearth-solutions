problem link-https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/repeated-k-times/description/?layout=old

import java.io.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,x,N=100000,c[]=new int[N+1];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            x=Integer.parseInt(s[i]);
            c[x]++;
        }
        int k=Integer.parseInt(bu.readLine()),ans=-1;
        for(i=0;i<=N;i++)
        if(c[i]==k) {ans=i; break;}
        System.out.print(ans);
    }
}
