problem link-https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/practice-problems/algorithm/raghu-vs-sayan/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int a=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]),n=Integer.parseInt(s[2]),i;
            s=bu.readLine().split(" ");
            int x[]=new int[n];
            for(i=0;i<n;i++)
            x[i]=Integer.parseInt(s[i]);
            Arrays.sort(x);
            int c1=0,c2=0,w1=0,w2=0;
            for(i=0;i<n;i++)
            {
                if(w1+x[i]<=a) {w1+=x[i]; c1++;}
                if(w2+x[i]<=b) {w2+=x[i]; c2++;}
                // if(w1+x[i]>a && w2+x[i]>b) break;
            }
            if(c1>c2) sb.append("Raghu Won\n");
            else if(c1<c2) sb.append("Sayan Won\n");
            else sb.append("Tie\n");
        }
        System.out.print(sb);
    }
}
