problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/gold-mines-10/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,j,q;
        long a[][]=new long[n][m];
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m;j++)
            {
                a[i][j]=Long.parseLong(s[j]);
                if(i>0) a[i][j]+=a[i-1][j];
            }
        }
        q=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int x1=Integer.parseInt(s[0])-2,y1=Integer.parseInt(s[1])-1,
            x2=Integer.parseInt(s[2])-1,y2=Integer.parseInt(s[3])-1;
            long sum=0;
            for(i=y1;i<=y2;i++)
            if(x1<0) sum+=a[x2][i];
            else sum+=a[x2][i]-a[x1][i];
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}
