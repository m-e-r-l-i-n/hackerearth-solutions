problem link-https://www.hackerearth.com/problem/algorithm/weird-number-e7dc0051/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long l=Long.parseLong(s[0]),r=Long.parseLong(s[1]);
            int k=Integer.parseInt(s[2]);
            long ans=count(r,k)-count(l,k)+(isspecial(l,k)?1:0);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static boolean isspecial(long n,int k)
    {
        while(n!=0)
        {
            int d=(int)(n%10);
            if(d%k!=0) return false;
            n/=10;
        }
        return true;
    }

    static long count(long n,int k)
    {
        long ans=0;
        ArrayList<Integer> al=new ArrayList<>();
        int i,sz,r=(int)Math.log10(n);
        for(i=0;i<10;i++)
        if(i%k==0) al.add(i);
        sz=al.size();
        long p=1,mul[]=new long[r+1];
        for(i=0;i<=r;i++)
        {
            mul[i]=p;
            p*=sz;
        }

        int a[]=new int[r+1];
        i=0;
        long no=n;
        while(n!=0)
        {
            a[i++]=(int)(n%10);
            n/=10;
        }
        n=no;
        for(i=r;i>=0;i--)
        {
            long cnt=0; int j,e=0;
            for(j=0;j<al.size();j++)
            if(al.get(j)<a[i]) e++;
            cnt=mul[i]*e;
            ans+=cnt;
            if(a[i]%k!=0) break;
            if(i==0) ans++;
        }
        return ans;
    }
}
