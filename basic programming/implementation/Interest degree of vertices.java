problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/all-equal-tree-401d4399/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,a[]=new int[n];
        String s[]=bu.readLine().split(" ");
        s=bu.readLine().split(" ");
        int min=1000000000;
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            if(a[i]<min) min=a[i];
        }
        if(a[0]!=min)
        {System.out.print(0); return;}
        long sum=0;
        for(i=0;i<n;i++)
        sum+=a[i]-min;
        System.out.print(sum);
    }
}
