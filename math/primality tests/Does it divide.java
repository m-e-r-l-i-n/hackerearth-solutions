problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/does-it-divide-3c60b8fb/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine())+1;
            int i,flag=0,base=n-1;
            for(i=2;i*i<=n;i++)
            if(n%i==0) 
            while(n%i==0) n/=i;
            if(base!=1 && n>base) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.print(sb);
    }
}
