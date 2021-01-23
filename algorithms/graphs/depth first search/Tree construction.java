problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/approximate/tree-construction-7b3cb288/?layout=old

//https://codeforces.com/contest/1098/submission/48031753
//shameless problem setter
import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),i;
        long m=Long.parseLong(s[1]);
        int ans=0;
        if(m*2>1l*n*(n+1)) ans=-1;
        else if(m<n*2-1) ans=-1;
        if(ans==-1) {System.out.print(-1); return;}

        for(i=1;i<=n;i++)
        {
            long dep=1,cnt=1,t=1,c=1;
            while(cnt<n)
            {
                c=c*i;
                dep++;
                t+=dep*Math.min(c,n-cnt);
                cnt+=c;
            }
            if(t<=m)break;
        }

        int a[]=new int[n+1],dep=1,cnt=1;
        long t=1,c=1;
        a[1]=1;

        while(cnt<n)
        {
            dep++;
            c=c*i;
            a[dep]=(int)Math.min(c,n-cnt);
            t+=1l*Math.min(c,n-cnt)*dep;
            cnt+=c;
        }
        m-=t;

        int now=dep,aft=dep+1;
        while(m>0)
        {
            if(a[now]<=1) now--;
            a[now]--;
            long tmp=Math.min(aft++,m+now);
            m-=tmp-now;a[(int)tmp]++;
        }
        int lst=1,p=i,fa[]=new int[n+1];
        for(i=2;i<aft;i++)
        {
            int nowp=lst-a[i-1]+1,nowk=0;
            for(int j=lst+1;j<=lst+a[i];j++)
            {
                if(nowk==p) {nowp++; nowk=0;}
                nowk++;
                fa[j]=nowp;
            }
            lst+=a[i];
        }
        for(i=2;i<=n;i++)
        sb.append(i+" "+fa[i]+"\n");
        System.out.print(sb);
    }
}
