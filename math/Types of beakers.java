problem link-https://www.hackerearth.com/problem/algorithm/bacteria-9a88c37f/

import java.io.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine()),v=0;
        StringBuilder sb=new StringBuilder();
        long pow2[]=new long[64];
        pow2[0]=1l;
        for(v=1;v<64;v++)
        pow2[v]=pow2[v-1]*2;
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long n=Long.parseLong(s[0]),k=Long.parseLong(s[1]),val=0,c=0;
            int i=0,d=(int)(Math.log(n)/Math.log(2l));
            if(pow2[d]<n) d++;
            d++;
            c=(k/n)*d;
            k=k%n;
            if(k!=0)
            {
                d=(int)(Math.log(k)/Math.log(2));
                if(pow2[d]<k) d++;
                d++; 
                c+=d;
            }
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
