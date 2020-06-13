problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/ultra-prime/

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        boolean sieve[]=new boolean[1000001];
        int i,j,c=0,count[]=new int[1000001];
        
        for(i=2;i<=1000000;i++)
        if(sieve[i]==false)
        {
            for(j=2*i;j<=1000000;j+=i)
            sieve[j]=true;
        }
        
        ArrayList<Integer> pr=new ArrayList<>();
        for(i=2;i<=1000;i++)
        if(sieve[i]==false) pr.add(i);
        
        for(i=2;i<=1000000;i++)
        {
            if(sieve[i]==false)
            {
                int sum=0,no=i;
                while(no>0)
                {sum+=no%10;
                no/=10;}
                if(pr.contains(sum)) c++;
            }
            count[i]=c;
        }
        
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0])-1,r=Integer.parseInt(s[1]);
            sb.append(count[r]-count[l]+"\n");
        }
        System.out.print(sb);
    }
}
