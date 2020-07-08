problem link-https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/kshitiz-and-matrix-7ddc9719/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            StringTokenizer st=new StringTokenizer(bu.readLine());
            int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),i,j,a[][]=new int[n][m],max=0,min=Integer.MAX_VALUE;

            for(i=0;i<n;i++)
            {
                st=new StringTokenizer(bu.readLine());
                for(j=0;j<m;j++)
                {
                    a[i][j]=Integer.parseInt(st.nextToken());
                    max=Math.max(a[i][j],max);
                    min=Math.min(a[i][j],min);
                }
            }

            int ans=0,row[]=new int[n],col[]=new int[m];
            for(i=0;i<n;i++)
            for(j=0;j<m;j++)
            if(a[i][j]==max || a[i][j]==min)
            {row[i]++; col[j]++;}
            for(i=0;i<n;i++)
            for(j=0;j<m;j++)
            if(row[i]==0 && col[j]==0) ans++;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
