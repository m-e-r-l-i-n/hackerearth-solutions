problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/long-jump-1-7d02705a/?layout=old

import java.io.*;
import java.util.*;
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(bu.readLine().trim()),n=Integer.parseInt(bu.readLine()),i,j;
        int a[]=new int[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        System.out.print(length(a,k));
    }

    /*stack overflow brilliant solution
    how to find longest increasing subsequence with difference at least k in nlog(n) time
    this can be directly used while taking input as well and without using lists
    */

    public static int length(int[] a, int K) 
    {
        int i,n=a.length;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(a[0]);
        for(i=1;i<a.length;i++) 
        if(a[i]-l.get(l.size()-1)>=K) l.add(a[i]);
        else  
        {
            int j=Collections.binarySearch(l,a[i]);
            if(j>=0 && j<a.length) l.set(j,a[i]);
            else 
            {
                if(-j-1>l.size()-1)
                {
                    if(a[i]-l.get(l.size()-1)>=K) l.add(a[i]);
                }
                else
                {
                    if(-j-1==0) l.set(-j-1,a[i]);
                    else if(a[i]-l.get(-j-2)>=K)l.set(-j-1,a[i]);
                }
            }
        }
        return l.size();
    }
}
