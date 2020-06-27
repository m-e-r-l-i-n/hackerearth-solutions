problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/max-num-eb15ff4f/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        int pow2[]=new int[31],cnt;
        pow2[0]=1;
        for(cnt=1;cnt<31;cnt++) pow2[cnt]=2*pow2[cnt-1];

        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),x=Integer.parseInt(s[1]),i,k;
            int c[]=new int[31];
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                k=Integer.parseInt(s[i]);
                int v=0;
                while(k!=0)
                {
                    c[v++]+=k&1;
                    k>>=1;
                }
            }
            int tot=0;
            HashMap<Long,Integer> hm=new HashMap<>();
            ArrayList<Long> al=new ArrayList<>();
            for(i=0;i<31;i++)
            if(c[i]!=0)
            {
                tot++;
                long val=1l*pow2[i]*c[i];
                if(hm.get(val)==null)
                {
                    al.add(val);
                    hm.put(val,1);
                }
                else hm.put(val,hm.get(val)+1); //hm stores no of bits that can yield max value
            }
            if(x>tot) {sb.append("-1\n"); continue;}

            Collections.sort(al,Collections.reverseOrder());
            int greed=x;
            for(i=0;i<al.size();i++)
            if(greed<=0) break;
            else greed-=hm.get(al.get(i));
            //suppose we can choose 3 elements...there are 5 present..hence no of ways=ncr(5,3);
            //greed=-2...so we need to make greed=5-2=3
            greed=hm.get(al.get(i-1))+greed;
            sb.append(ncr(hm.get(al.get(i-1)),greed)+"\n");
        }
        System.out.print(sb);
    }

    static long ncr(int n,int r)
    {
        if(n-r<r) r=n-r;
        long deno=1,num=1,i;
        for(i=1;i<=r;i++)
        {
            deno=deno*i;
            num=num*(n-i+1);
            long g=gcd(deno,num);
            deno/=g; num/=g;
        }
        return num/deno;
    }

    static long gcd(long a,long b)
    {
        long t;
        if(a<b) a=a^b^(b=a);
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
