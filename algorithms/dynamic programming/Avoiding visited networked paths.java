problem link-https://www.hackerearth.com/problem/algorithm/avoiding-networked-paths-revisited-38d27ffb/?layout=old

import java.io.*;
import java.util.*;
 
class TestClass 
{
    static Fac f[]=new Fac[18];
    public static void main(String args[] )throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,j,k,t=0;
        long a[][]=new long[n][m],M=1000000007,c[][][]=new long[n][m][18];
        Fac p[][]=new Fac[n][m];
        HashMap<Integer,Fac> hm=new HashMap<>();
        //107^2*1361^2*10000019^1=212072634227239451
        
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m;j++)
            {
                a[i][j]=Long.parseLong(s[j]);
                int c1=0,c2=0,c3=0;
                while(a[i][j]%107==0) {a[i][j]/=107; c1++;}
                while(a[i][j]%1361==0) {a[i][j]/=1361; c2++;}
                while(a[i][j]%10000019==0) {a[i][j]/=10000019; c3++;}
                p[i][j]=new Fac(c1,c2,c3);
            }
        }
 
        for(i=0;i<3;i++)
        for(j=0;j<3;j++)
        for(k=0;k<2;k++)
        {f[t]=new Fac(i,j,k);
        hm.put(t,f[t++]);}
        c[0][0][pos(p[0][0])]++;
 
        for(i=1;i<n;i++)
        {
            for(j=0;j<18;j++)
            if(c[i-1][0][j]==0) continue;
            else
            {
                Fac x=hm.get(j);
                Fac y=new Fac(x.a+p[i][0].a,x.b+p[i][0].b,x.c+p[i][0].c);
                c[i][0][pos(y)]+=c[i-1][0][j];
            }        
            c[i][0][17]=0;
        }
        for(i=1;i<m;i++)
        {
            for(j=0;j<18;j++)
            if(c[0][i-1][j]==0) continue;
            else
            {
                Fac x=hm.get(j);
                Fac y=new Fac(x.a+p[0][i].a,x.b+p[0][i].b,x.c+p[0][i].c);
                c[0][i][pos(y)]+=c[0][i-1][j];
            }        
            c[0][i][17]=0;
        }
 
        for(i=1;i<n;i++)
        for(j=1;j<m;j++)
        {
            for(k=0;k<18;k++)
            if(c[i-1][j][k]==0) continue;
            else
            {
                Fac x=hm.get(k);
                Fac y=new Fac(x.a+p[i][j].a,x.b+p[i][j].b,x.c+p[i][j].c);
                int pos=pos(y);
                c[i][j][pos]=(c[i][j][pos]+c[i-1][j][k])%M;
            }        
            for(k=0;k<18;k++)
            if(c[i][j-1][k]==0) continue;
            else
            {
                Fac x=hm.get(k);
                Fac y=new Fac(x.a+p[i][j].a,x.b+p[i][j].b,x.c+p[i][j].c);
                int pos=pos(y);
                c[i][j][pos]=(c[i][j][pos]+c[i][j-1][k])%M;
            }        
            c[i][j][17]=0;         
        }
        long ans=0;
        for(i=0;i<17;i++)
        ans=(ans+c[n-1][m-1][i])%M;
        System.out.print(ans);
    } 
    static int pos(Fac k)
    {
        int i=0;
        for(;i<18;i++)
        if(k.a==f[i].a && k.b==f[i].b && k.c==f[i].c) break;
        return i;
    }
 
    static class Fac
    {
        int a,b,c;
        Fac(int x,int y,int z)
        {
            if(x>2) x=2;
            if(y>2) y=2;
            if(z>1) z=1;
            a=x; b=y; c=z;
        }
    }
}
