problem link-https://www.hackerearth.com/problem/algorithm/reverse/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main (String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());

        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
            int sz=k*k+1,c=1,i,p=0;
            long[] vec=new long[sz];
            vec[0]=vec[sz-1]=1;

            // powers of 10 might not be periodic yet, so manually do first k cases.
            for(i=0;i<k && n>0; i++)
            {
                vec=vec_mult(createMat(sz,c,k),vec);
                --n;
                c=c*10%k;
            }

            // now powers of 10 should be periodic
            boolean seen[]=new boolean[k];
            long all[][]=new long[sz][sz];
            for(i=0;i<sz;i++) all[i][i]=1;

            while(n>0 && !seen[c])
            {
                seen[c]=true;
                ++p;
                long mat[][]=createMat(sz,c,k);
                vec=vec_mult(mat,vec);
                all=mat_mult(mat,all);
                --n;
                c=(c*10)%k;
            }

            if(n>0 && n>=p)
            {
                vec=vec_mult(mat_exp(all,n/p),vec);
                n%=p;
            }
            while(n>0)
            {
                vec=vec_mult(createMat(sz,c,k),vec);
                --n;
                c=(c*10) % k;
            }
            sb.append(vec[sz-1]+"\n");
        }
        System.out.print(sb);
    }

    static long[][] createMat(int sz, int c, int k)
    {
        long[][] mat=new long[sz][sz];
        mat[sz-1][sz-1]=1;
        int pf,pb,d;
        for(pf=0;pf<k;pf++)
        for(pb=0;pb<k;pb++)
        for(d=0;d<=9;d++)
        {
            int nf=((d*c)+pf)%k;
            int nb=(10*pb+d)% k;
            mat[nf*k+nb][pf*k+pb]++;
            if(nf==0 && nb==0 && d!=0) mat[sz-1][pf*k+pb]++;
        }
        return mat;
    }
    
    static long[][] mat_mult(long[][] a, long[][] b)
    {
        int i,j,k,n=a.length;
        long c[][]=new long[n][n],M=1000000007;
        for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        for(k=0;k<n;k++)
        c[i][k]=(c[i][k]+a[i][j]*b[j][k])%M;
        return c;
    }

    static long[] vec_mult(long[][] A, long[] B)
    {
        long C[]=new long[A.length],M=1000000007;
        for(int i=0;i<A.length;i++)
        for(int j=0;j<B.length;j++)
        C[i]=(C[i]+A[i][j]*B[j])%M;
        return C;
    }

    static long[][] mat_exp(long[][] a, int e)
    {
        if(e==1) return a;
        else if(e%2==0)
        {
            long[][] a1=mat_exp(a,e/2);
            return mat_mult(a1,a1);
        }
        else return mat_mult(a,mat_exp(a,e-1));
    }
}
