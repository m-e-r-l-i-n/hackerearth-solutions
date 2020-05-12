problem link-https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/transpose/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),a[][]=new int[m][n],i,j;
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m;j++)
            a[j][i]=Integer.parseInt(s[j]);
        }
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            sb.append(a[i][j]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
