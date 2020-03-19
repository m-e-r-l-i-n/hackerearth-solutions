problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/the-castle-gate-july-easy/

import java.io.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,j,c=0;
            for(i=1;i<n;i++)
            for(j=i+1;j<=n;j++)
            if((i^j)<=n) c++;
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
