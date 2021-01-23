problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/make-them-equal-too-89585e71/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            char a[]=bu.readLine().trim().toCharArray();
            char b[]=bu.readLine().trim().toCharArray();

            int i,ca[]=new int[26],cb[]=new int[26];
            for(char x:a) ca[x-'a']++;
            for(char x:b) cb[x-'a']++;
            boolean pos=true;
            for(i=0;i<26;i++)
            if(ca[i]-cb[i]!=0) {pos=false; break;}
            if(!pos) {sb.append("NO\n"); continue;}

            long ia=merge(a,0,n-1),ib=merge(b,0,n-1);
            if(Math.abs(ia-ib)%2==0) sb.append("YES\n");
            else
            {
                int ua=0,ub=0;
                for(i=0;i<26;i++)
                {
                    if(ca[i]==1) ua++;
                    if(cb[i]==1) ub++;
                }

                if((ia>ib && ua==n) || (ia<ib && ub==n)) sb.append("NO\n");
                else sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }
    static int N=200000;
    static char tem[]=new char[N];

    static long count(char a[],int l,int m,int r)
    {
        long inv=0;
        int i=l,j=m,k=l; /* i is index for resultant merged subarray*/
        while(i<m && j<=r)
        {
            if(a[i]<=a[j]) tem[k++]=a[i++];
            else
            {
                tem[k++]=a[j++];
                inv+=m-i;
            }
        }

        while(i<m) tem[k++]=a[i++];
        while(j<=r) tem[k++]=a[j++];

        for(i=l;i<=r;i++) a[i]=tem[i];
        return inv;
    }

    static long merge(char a[],int l,int r)
    {
        int mid;
        long inv=0;
        if(r>l)
        {
            mid=(r+l)/2;
            inv=merge(a,l,mid);
            inv+=merge(a,mid+1,r);
            inv+=count(a,l,mid+1,r);
        }
        return inv;
    }
}
