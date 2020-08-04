problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/harry-and-horcrux-1-df65f8e9/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),x,N=1000000;
        long sum=0,M=1000000007;
        long f[]=new long[N+1];
        f[0]=1;
        for(x=1;x<=N;x++)
        f[x]=f[x-1]*x%M;
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            int i,j=1,a[]=new int[n];
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            Arrays.sort(a);

            sum=0;
            for(i=n-1;i>=0;i--)
            {
                sum+=f[j]*a[i]%M;
                sum%=M;
                j++;
            }
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}
