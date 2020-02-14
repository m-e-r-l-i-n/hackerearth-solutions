problem link-https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/wet-clothes-625348cf/

import java.io.*;
import java.util.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int g=sc.nextInt();
        int i,j,t[]=new int[n],tm[]=new int[n-1],a[]=new int[m];
        for(i=0;i<n;i++)
        {
            t[i]=sc.nextInt();
            if(i!=0)
            tm[i-1]=t[i]-t[i-1];
        }
        for(i=0;i<m;i++)
        a[i]=sc.nextInt();
        Arrays.sort(a);
        int cl=0,c=0;
        for(i=1;i<n;i++)
        {
            int te=t[i]-t[i-1];
            for(j=c;j<m;j++)
            if(a[j]<=te)
            {c=j+1;++cl;}
            if(c>=m) break;
        }
        System.out.print(cl);
    }
}
