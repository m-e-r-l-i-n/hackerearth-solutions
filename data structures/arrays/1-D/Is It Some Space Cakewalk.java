problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/is-it-some-space-cakewalk/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,k,un=0; byte u[]=new byte[100001];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i]);
            if(u[k]==0) {u[k]++; un++;}
        }
        System.out.print(++un);
    }
}
