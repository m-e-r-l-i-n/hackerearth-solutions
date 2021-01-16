problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/move-minimization-8a9d3991/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bu.readLine());
        int i,j,a[]=new int[n],ans=0; bit=new int[n+2];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            ans+=i-query(a[i]);
            update(a[i],1);
        }
        Arrays.fill(bit,0);

        int inv=ans;
        for(i=0;i<n;i++)
        if(a[i]!=(i+1))
        {
            for(j=i+1;j<n;j++)
            {
                if(a[j]!=(j+1) && a[j]<a[i])    //we can ensure inversions will decrease only when a[j]<a[i] & i>j
                {
                    int cur=inv-1;    
                    cur-=2*(query(a[i])-query(a[j]));
                    //change in inversions=old-1-2*number of elements in(i,j) such that a[j]<a[k]<a[i]
                    ans=Math.min(ans,cur);
                }
                update(a[j],1);
            }
            for(j=i+1;j<n;j++)
            update(a[j],-1);    //we need to reuse the fenwick tree
        }
        System.out.print(ans);
    }
    static int n,bit[];
    static void update(int i,int v)
    {
        i++;
        while(i<=n+1)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }

    static int query(int i)
    {
        i++;
        int s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
