problem link-https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/step-conversion/description/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[] )throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int k=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),n=Integer.parseInt(s[2]);
            sb.append(steps(k,m,n)+"\n");
        }
        System.out.print(sb);
    }

    static int steps(int k,int m,int n)
    {
        if(k>=m) return (k-m)/2+(k-m)%2;
        if(m%n==0) return 1+steps(k,m/n,n);
        int x=(m/n+1)*n;
        return (x-m)/2+(x-m)%2+steps(k,x,n);
    }
}
