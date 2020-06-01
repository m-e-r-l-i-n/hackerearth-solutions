problem link-https://www.hackerearth.com/problem/algorithm/dummy4-4/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),a[]=new int[n],x,i;
        s=bu.readLine().split(" ");
        int l=Integer.MAX_VALUE,r=0,mid=0;            
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            x=Integer.parseInt(s[i]);
            if(hm.get(x)==null)
            {
                int c=0,j;
                for(j=1;j*j<=x;j++)
                if(x%j==0)
                {
                    c++;
                    if(x/j!=j) c++;
                }
                hm.put(x,c);
            }
            a[i]=hm.get(x);
            if(a[i]<l) l=a[i];
            r+=a[i];
        }

        int ans=0;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(binarycheck(a,k,mid)) {ans=mid; r=mid-1;}
            else l=mid+1;
        }
        System.out.print(ans);
    }

    static boolean binarycheck(int a[],int k,int sum)
    {
        int s=0,c=1,i,n=a.length;
        for(i=0;i<n;i++)
        {
            if(a[i]>sum) {c=k+1; break;}
            s+=a[i];
            if(s>sum) {c++; s=a[i];}
        }
        return c<=k;
    }
}
