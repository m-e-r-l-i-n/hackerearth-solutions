problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/trie-keyword-tree/practice-problems/algorithm/ma5termind-and-xor-minimization/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        String s[]=bu.readLine().split(" ");
        int sum[]=new int[100005],a[]=new int[n],i,j,M=1000000007;
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        sum[0]=1;
        for(i=0;i<n;i++)
        for(j=100000;j>=a[i];j--)
        if(sum[j-a[i]]!=0)
        {
            sum[j]+=sum[j-a[i]];
            sum[j]%=M;
        }

        Node r=new Node();
        for(i=1;i<=100000;i++)
        if(sum[i]!=0) initialize(r,i);

        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int q=Integer.parseInt(bu.readLine());
            q=query(r,q);
            sb.append(q+" "+sum[q]+"\n");
        }
        System.out.print(sb);
    }

    static class Node   //trie
    {
        Node l,r;
        Node()
        {
            l=null;
            r=null;
        }
    }

    static void initialize(Node r,int n)
    {
        int i,x;
        for(i=30;i>=0;i--)
        {
            x=(1<<i)&n;
            if(x!=0)
            {
                if(r.r==null) r.r=new Node();
                r=r.r;
            }
            else
            {
                if(r.l==null) r.l=new Node();
                r=r.l;
            }
        }
    }

    static int query(Node r,int n)
    {
        int ans=0,i,x;
        for(i=30;i>=0;i--)
        {
            x=n&(1<<i);
            if(x==0)
            {
                if(r.l!=null) r=r.l;
                else
                {
                    ans|=(1<<i);
                    r=r.r;
                }
            }
            else
            {
                if(r.r!=null)
                {
                    ans|=(1<<i);
                    r=r.r;
                }
                else r=r.l;
            }
        }
        return ans;
    }
}
