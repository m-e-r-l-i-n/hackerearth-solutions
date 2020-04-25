problem link-https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/people-carrying-6dd467ed/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),a[]=new int[n],b[]=new int[m],i;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        Arrays.sort(a);
        s=bu.readLine().split(" ");
        for(i=0;i<m;i++)
        b[i]=Integer.parseInt(s[i]);
        Arrays.sort(b);
        if(a[n-1]>b[m-1]) {System.out.print("-1"); return;}
        if(m==1) {System.out.print(2*n-1); return;}
        if(n==1) {System.out.print(1); return;}
        int c=0,j=0,op=n/m,opt[]=new int[m];
        if(n%m!=0) op++;
        for(i=0;i<n;i++)
        {
            if(a[i]<=b[j]) c++;
            else
            {
                opt[j++]=c;
                c=0;
                i--;
            }
        }
        if(j<m-1) {System.out.print(2*op-1); return;}
        if(j==m-1) opt[j]=c;
        int max=0,carry=0;
        for(i=0;i<m;i++)
        {
            opt[i]+=carry;
            if(i!=m-1 && opt[i]-op>0) {carry=opt[i]-op; opt[i]=op;}
            else carry=0;
            if(opt[i]>max) max=opt[i];
        }
        System.out.print(2*max-1);      
    }
}
