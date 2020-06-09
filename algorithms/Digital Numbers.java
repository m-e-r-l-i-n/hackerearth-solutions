problem link-https://www.hackerearth.com/problem/algorithm/digital-numbers/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    static int c[]={6,2,5,5,4,5,6,3,7,6};
    static long f[]=new long[11];
    static long ans;
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i;
        f[0]=1;
        for(i=1;i<=10;i++) f[i]=i*f[i-1];
        long an[][]=new long[11][286];
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),d=m/7; ans=0;
            if(l==0) l=10;
            if(an[l][d]!=0) {sb.append(an[l][d]+"\n"); continue;}
            boolean z=false;
            for(i=1;i<=l;i++)
            for(int j=0;j+i<=c.length;j++)
            {
                if(j==0) z=true;
                else z=false;
                solve(c[j],1,j,i,d,z);
            }
            sb.append(ans+"\n");
            an[l][d]=ans;
        }
        System.out.print(sb);
    }

    static void solve(int sum,int cn,int i, int l,int tubes,boolean zero)
    {
        if(cn==l)
        {
            if(sum<=tubes)
            {
                ans+=f[cn];
                if(zero && cn!=1) ans-=f[cn-1];
            }
            return;
        }
        for(int j=i+1;j<c.length;j++)
            solve(sum+c[j],cn+1,j,l,tubes,zero);
    }
}
