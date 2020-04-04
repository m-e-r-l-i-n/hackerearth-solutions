problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/subsequence-again-19245c50/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int q=Integer.parseInt(bu.readLine());
        int c[]=new int[100001],i,j,co=0;
        for(i=1;co!=100000;i++)
        {
            String s=Integer.toString(i);
            char ch=s.charAt(0);
            if(ch=='1' || ch=='3' || ch=='5' || ch=='7' || ch=='9') {co++; c[co]=i;} 
        }
        while(q-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(1+" "+c[n]+"\n");
        }
        System.out.print(sb);
    }
}
