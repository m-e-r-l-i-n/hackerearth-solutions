problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/lets-begin/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int N=1000000,c[]=new int[N+1],i,m[]={2,3,5,7},j;
        for(i=1;i<=N;i++)
        c[i]=Integer.MAX_VALUE;
        for(i=1;i<=N;i++)
        for(j=0;j<4;j++)
        if(m[j]<=i)
        {
            int min=c[i-m[j]];
            if(min!=Integer.MAX_VALUE && min+1<c[i]) c[i]=min+1;
        }
        c[1]=c[0]=-1;
        
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(c[n]+"\n");
        }
        System.out.print(sb);
    }
}
