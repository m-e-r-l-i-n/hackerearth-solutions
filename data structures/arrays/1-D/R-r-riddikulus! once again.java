problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/k-rotation-is-what-you-can-855157f8/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),d=Integer.parseInt(s[1]),i;
        StringBuilder sb=new StringBuilder();
        s=bu.readLine().split(" ");
        for(i=d;i<n;i++)
        sb.append(s[i]+" ");
        for(i=0;i<d;i++)
        sb.append(s[i]+" ");
        System.out.print(sb);
    }
}
