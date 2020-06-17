problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/password-1/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i;
        String s[]=new String[n];
        for(i=0;i<n;i++)
        s[i]=bu.readLine();
        Arrays.sort(s);
        int p=0,j,m;
        for(i=0;i<n;i++)
        {
            char s2[]=s[i].toCharArray();
            m=s2.length;
            for(j=0;j<=m/2;j++)
            {
                char t=s2[j];
                s2[j]=s2[m-j-1];
                s2[m-j-1]=t;
            }
            if(Arrays.binarySearch(s,new String(s2))>=0) {p=i; break;}
        }
        System.out.print(s[p].length()+" "+s[p].charAt(s[p].length()/2));
    }
}
