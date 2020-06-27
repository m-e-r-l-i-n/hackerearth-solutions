problem link-https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/bubble-sort-15-8064c987/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),c=0,i,a[]=new int[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        boolean swaps=true;
        while(swaps)
        {
            swaps=false;
            c++;
            for(i=0;i<n-1;i++)
            if(a[i]>a[i+1])
            {
                swaps=true;
                a[i]=a[i]^a[i+1]^(a[i+1]=a[i]);
            }
        }
        System.out.print(c);
    }
}
