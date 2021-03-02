problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/incremental-queries-a7a71194/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
        int i,a[]=new int[n]; st=new int[4*n];
        long bito[]=new long[n+1],bite[]=new long[n+1],bitc[]=new long[n+1];

        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            updatest(0,n-1,i,a[i],0);
            if(a[i]%2==0) updatebit(bite,i,n,a[i]);
            else
            {
                updatebit(bito,i,n,a[i]);
                updatebit(bitc,i,n,1);
            }
        }

        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int t=Integer.parseInt(s[0]),l=Integer.parseInt(s[1]),r=Integer.parseInt(s[2]);
            l--;
            if(t==1)
            {
                updatest(0,n-1,l,r,0);
                if(a[l]%2==0) updatebit(bite,l,n,-a[l]);
                else
                {
                    updatebit(bito,l,n,-a[l]);
                    updatebit(bitc,l,n,-1);
                }
                a[l]=r;
                if(r%2==0) updatebit(bite,l,n,r);
                else
                {
                    updatebit(bito,l,n,r);
                    updatebit(bitc,l,n,1);
                }
            }
            else
            {
                r--;
                int max=queryst(0,n-1,l,r,0);
                int odd=(int)(querybit(bitc,r)-querybit(bitc,l-1)),even=r-l+1-odd;
                long sodd=querybit(bito,r)-querybit(bito,l-1),seven=querybit(bite,r)-querybit(bite,l-1);
                long moves=0;
                if(max%2==0) moves=((1l*even*max-seven)/2)+((1l*odd*max-sodd-odd)/2)+odd;
                else moves=((1l*odd*max-sodd)/2)+((1l*even*max-seven-even)/2)+even;
                sb.append(moves+"\n");
            }
        }
        System.out.print(sb);
    }

    static int st[];
    static void updatest(int ss,int se,int i,int v,int n)
    {
        if(i<ss || i>se) return;

        if(ss==se) st[n]=v;
        else
        {
            int mid=ss+(se-ss)/2;
            if(i>=ss && i<=mid) updatest(ss,mid,i,v,2*n+1);
            else updatest(mid+1,se,i,v,2*n+2);
            st[n]=Math.max(st[2*n+1],st[2*n+2]);
        }
        return;
    }

    static int queryst(int ss,int se,int qs,int qe,int n)
    {
        if(qs<=ss && qe>=se) return st[n];
        if(se<qs || qe<ss) return -1;

        int mid=ss+(se-ss)/2;
        return Math.max(queryst(ss,mid,qs,qe,2*n+1),queryst(mid+1,se,qs,qe,2*n+2));
    }

    static void updatebit(long bit[],int i,int n,int v)
    {
        i++;
        while(i<=n)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }

    static long querybit(long bit[],int i)
    {
        i++;
        long s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
