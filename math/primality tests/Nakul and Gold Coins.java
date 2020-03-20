problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/nakul-and-gold-coins/

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        boolean sieve[]=new boolean[1000001];
        int i,j;
        ArrayList<Integer> pr=new ArrayList<>();
        for(i=2;i<=1000000;i++)
        if(sieve[i]==false)
        {
            pr.add(i);
            for(j=2*i;j<=1000000;j+=i)
            sieve[j]=true;
        }

        int count[]=new int[100000001];
        for(i=0;i<pr.size();i++)
        {
            int f=0,x=pr.get(i);
            for(j=i+1;j<pr.size();j++)
            {
                int y=pr.get(j);
                long ll=x*y;
                if(ll>100000000) break;
                count[(int)ll]++;

            }
            if(j==i+1) break;
        }
        for(i=1;i<=100000000;i++)
        count[i]+=count[i-1];

        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0])-1,r=Integer.parseInt(s[1]),c=0;
            sb.append(count[r]-count[l]+"\n");
        }
        System.out.print(sb);
    }
}
