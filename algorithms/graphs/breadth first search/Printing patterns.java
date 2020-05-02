problem link-https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/waves-b18625d7/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int r=Integer.parseInt(s[0]),c=Integer.parseInt(s[1]),x=Integer.parseInt(s[2]),y=Integer.parseInt(s[3]);
        int a[][]=new int[r][c],i,j;
        for(i=0;i<r;i++)
        for(j=0;j<c;j++)
        a[i][j]=(int)Math.max(Math.abs(x-i),Math.abs(y-j));
        
        StringBuilder sb=new StringBuilder();
        for(i=0;i<r;i++)
        {for(j=0;j<c;j++)
        sb.append(a[i][j]+" ");
        sb.append("\n");}
        System.out.print(sb);
    }
}
