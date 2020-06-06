problem link-https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/yet-another-easy-problem-1f3273a0/description/?layout=old

import java.io.*;
 
class TestClass
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,c[]=new int[100001],cnt=0;
        for(i=1;i<=100000;i++)
        {
            int hex=0,dec=i;
            while(dec!=0)
            {
                hex+=dec%16;
                dec/=16;
            }
            if(gcd(i,hex)==1) cnt++;
            c[i]=cnt;
        }
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0])-1,r=Integer.parseInt(s[1]);
            sb.append((r-l)-(c[r]-c[l])+"\n");
        }
        System.out.print(sb);
    }
 
    static int gcd(int a,int b)
    {
        if(a<b) a=a^b^(b=a);
        while(b!=0)
        {
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
