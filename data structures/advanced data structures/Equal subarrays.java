problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/equal-subarrays-cf01a26a/

import java.io.*;
import java.math.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int k=Integer.parseInt(bu.readLine());
        String s[]=bu.readLine().split(" ");
        int i,a[]=new int[n],j,t,point=0,c=0,max[]=new int[n],maxs=0,maxi=0,maxp[]=new int[n]; 
        long sum[]=new long[n],sums=0;
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            if(a[i]>=maxs) {maxs=a[i]; maxi=i;}
            max[i]=maxs;
            sums+=a[i];
            sum[i]=sums;
            maxp[i]=maxi;
        }
        for(i=0;i<n;i++) 
        { 
            
            for(j=i+c;j<n;j++) 
            { 
                if(maxp[i]<i && max[i]>=max[j])
                {maxs=0;
                for(int v=i;v<n;v++)
                {if(a[v]>=maxs) {maxs=a[v];maxi=v;}
                max[v]=maxs;maxp[v]=maxi;}
                }
                
                int maxr=0;
                maxr=(int)(Math.max(max[i],max[j]));
                
                long sumr=0;
                if(i==0) sumr=sum[j];
                else sumr=sum[j]-sum[i-1];
                long temp=(maxr*(j-i+1)-sumr);
                if(temp<0) break;
                if(temp<=k && temp>=0 && (j-i+1)>c)
                c=(j-i+1);
            }
            
            if(c>n/2 && i>n/2) break;
        }
        System.out.print(c);
    }
}
