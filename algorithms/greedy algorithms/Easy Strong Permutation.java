problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/easy-strong-permutation/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,a[]=new int[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        Arrays.sort(a);
        int ar[]=new int[n],t=0;
        for(i=0;i<n/2;i++)
        {
            ar[t++]=a[i];
            ar[t++]=a[n-i-1];
        }
        if(n%2!=0) ar[t++]=a[i];
        long sum=0;
        for(i=1;i<n;i++)
        sum+=Math.abs(ar[i]-ar[i-1]);
        sum+=Math.abs(ar[n-1]-ar[0]);
        System.out.print(sum);
    }
}
