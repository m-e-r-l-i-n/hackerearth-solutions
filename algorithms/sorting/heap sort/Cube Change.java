problem link-https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/practice-problems/algorithm/cube-change-qualifier2/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            if(n<3) {sb.append(n*n*n+"\n"); continue;}
            long tsa=6l*n*n-12l*n+8;
            sb.append(tsa+"\n");
        }
        System.out.print(sb);
    }
}
