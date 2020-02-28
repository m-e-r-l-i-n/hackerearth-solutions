problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/playing-with-given-numbers/description/?utm_source=header&utm_medium=search&utm_campaign=he-search

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]), q=Integer.parseInt(s[1]),a[]=new int[n];
        long su[]=new long[n],sum=0;int i;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            sum+=a[i];
            su[i]=sum;
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<q;i++)
        {
            s=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0])-1,r=Integer.parseInt(s[1])-1;
            sb.append((su[r]-su[l]+a[l])/(r-l+1)+"\n");
        }
        System.out.print(sb);
    }
}
