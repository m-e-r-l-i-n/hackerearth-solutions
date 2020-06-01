problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/assorted-arrangement-3/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        int a[]=new int[n],c[]=new int[m],i;
        s=bu.readLine().split(" ");
        long l=1,lcm[]=new long[m],ans[]=new long[n];
        for(i=0;i<m;i++)
        c[i]=Integer.parseInt(s[i]);
        
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i])-1;
        long prev=0;
        for(i=0;i<n;i++)
        {
            long v=(prev/c[a[i]]+1)*c[a[i]];
            while(div(c,a[i],v)) v+=c[a[i]];
            prev=v;
        }
        System.out.print(prev);
    }

    static boolean div(int a[],int pos,long v)
    {
        for(int i=pos+1;i<a.length;i++)
        if(v%a[i]==0) return true;
        return false;
    }
}
