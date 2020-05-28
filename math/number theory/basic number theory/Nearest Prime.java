problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/nearest-prime-a828361b/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int N=1000500,p[]=new int[N+1],pre[]=new int[N+1],suf[]=new int[N+1],i,j,t;
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=2*i;j<=N;j+=i)
        p[j]=1;
        int pr=0,su=0;
        p[0]=1; p[1]=1;
        for(i=1;i<=N;i++)
        {
            if(p[i]==0) pr=0;
            else pr++;
            pre[i]=pr;
        }
        for(i=N;i>0;i--)
        {
            if(p[i]==0) su=0;
            else su++;
            suf[i]=su;
        }
        StringBuilder sb=new StringBuilder();
        t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            if(n==1) {sb.append(2+"\n"); continue;}
            if(pre[n]<=suf[n]) n-=pre[n];
            else n+=suf[n];
            sb.append(n+"\n");
        }
        System.out.print(sb);
    }
}
