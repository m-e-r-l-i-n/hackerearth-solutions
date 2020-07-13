problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/sorted-string-3-a95dada3/description/?layout=old

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String s = br.readLine();

         int out_ = solve(n, s);
         System.out.println(out_);

         wr.close();
         br.close();
    }

    static long bit[];
    static int solve(int n, String s){
       // Write your code here
        int i,sum=0; long ans=0,M=1000000007;
        bit=new long[200000+5];
        update(100000,1);
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='a') sum++;
            else if(s.charAt(i)=='c') sum--;
            update(100000+sum,1);
            long c=query(100000+sum-1);
            ans+=c;
            ans%=M;
        }
        return (int)ans;
    }

    static void update(int i,int v)
    {
        i++;
        while(i<bit.length)
        {
            bit[i]+=v;
            i+=i&(-i);
        }
    } 
    
    static long query(int i)
    {
        i++;
        long ans=0;
        while(i>0)
        {
            ans+=bit[i];
            i-=i&(-i);
        }
        return ans;
    }
}
