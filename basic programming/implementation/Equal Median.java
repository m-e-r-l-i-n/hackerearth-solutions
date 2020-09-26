problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/equal-median-8aba723b/description/?layout=old

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
            int n=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            int i,a[]=new int[n],b[]=new int[n];
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            Arrays.sort(a);
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            b[i]=Integer.parseInt(s[i]);
            Arrays.sort(b);
            sb.append(count(a,b)+"\n");
        }
        System.out.print(sb);
    }

    static int count(int a[],int b[])
    {
        int n=a.length,l[]=new int[2*n],i=0,j=0,k=0;
        while(i<n && j<n)
        if(a[i]>b[j]) l[k++]=b[j++];
        else l[k++]=a[i++];
        while(i<n) l[k++]=a[i++];
        while(j<n) l[k++]=b[j++];

        int med1=l[n-1],med2=l[n];
        if(med1 != med2) return -1;

        int sa=getSmall(a,med1),sb=getSmall(b,med1),eqa=getEqual(a,med1),eqb=getEqual(b,med1),la=getLarge(a,med1),lb=getLarge(b,med1);
        int seqa=sa+eqa,seqb=sb+eqb,leqa=la+eqa,leqb=lb+eqb;
        int mid=n/2+1;
        int ab=0,ba=0;

        if(eqa==0)
        {
            ba++;
            eqa++; eqb--;
        }

        if(eqb==0)
        {
            ab++;
            eqb++; eqa--;
        }

        seqa=sa+eqa;
        seqb=sb+eqb;
        leqa=la+eqa;
        leqb=lb+eqb;
        if(seqa<mid)
        {
            int x=mid-seqa;
            ba+=x;
            seqa+=x;
            seqb-=x;
        }

        if(seqb<mid)
        {
            int x=mid-seqb;
            ab+=x;
            seqa-=x;
            seqb+=x;
        }

        if(leqa<mid)
        {
            int x=mid-leqa;
            ba+=x;
            leqa+=x;
            leqb-=x;
        }

        if(leqb<mid)
        {
            int x=mid-leqb;
            ab+=x;
            leqa-=x;
            leqb+=x;
        }
        return Math.max(ab,ba);
    }

    static int getSmall(int a[],int k)
    {
        int l=0,r=a.length-1,ans=0,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a[mid]<k)
            {
                ans=mid+1;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }

    static int getLarge(int a[],int k)
    {
        int l=0,r=a.length-1,ans=r+1,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a[mid]>k)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return a.length-ans;
    }

    static int getEqual(int a[],int k)
    {
        return a.length-(getLarge(a,k)+getSmall(a,k));
    }
}
