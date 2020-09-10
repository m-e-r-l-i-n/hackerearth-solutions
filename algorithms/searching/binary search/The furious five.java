problem link-https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-furious-five-69521576/description/?layout=old

import java.io.*;

class TestClass
{
    public static void main (String[] args) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            long l=1,r=10000000000000l,mid,ans=1;
            while(l<=r)
            {
                mid=(l+r)/2;
                if(sum(mid)>=n)
                {
                    ans=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long sum(long n)
    {
        long a=0,cur=5;
        while(cur<=n)
        {
            a+=n/cur;
            cur*=5;
        }
        return a;
    }
}
