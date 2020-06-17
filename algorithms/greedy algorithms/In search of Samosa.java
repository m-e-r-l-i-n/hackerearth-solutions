problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/in-search-of-samosa-pledge-easy-3/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),a[]=new int[n],i;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        Arrays.sort(a);
        int sum=0,c=0;
        for(i=0;i<n;i++)
        if(sum+a[i]<=k)
        {c++; sum+=a[i];}
        System.out.print(c);
    }
}
