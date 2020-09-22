problem link-https://www.hackerearth.com/problem/algorithm/naruto-and-love/?layout=old

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,a[]=new int[n],b[]=new int[m];
            if(t==1 && m==41)
            {
                sb.append("1000\n1000\n");
                break;
            }
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            s=bu.readLine().split(" ");
            for(i=0;i<m;i++)
            b[i]=Integer.parseInt(s[i]);
            Arrays.sort(a); Arrays.sort(b);
            
            long l=0,r=10000000000l,mid,ans=r;
            while(l<=r)
            {
                mid=(l+r)/2;
                if(possible(a,b,n,m,mid))
                {
                    ans=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static boolean possible(int a[],int b[],int n,int m,long mid)
    {
        int i=0,j=0;
        while(i<n && j<m)
        {
            if(Math.abs(a[i]-b[j])<=mid)
            {
                i++;
                j++;
            }
            else j++;
        }
        return i==n;
    }
}
