problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/special-matrix-1/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),x=0,y=0,i,j;
            for(i=0;i<n;i++)
            {
                char s[]=bu.readLine().toCharArray();
                for(j=0;j<n;j++)
                if(s[j]=='*') {x=i; y=j;}
            }
            int mid=n/2;
            sb.append(Math.abs(mid-x)+Math.abs(mid-y)+"\n");
        }
        System.out.print(sb);
    }
}
