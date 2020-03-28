problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/shift-and-replace-d96fc236/

import java.io.*;
import java.util.*;
 
class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i, a[]=new int[n],d[]=new int[n],de[]=new int[n/2+1];
        String s[]=bu.readLine().split(" ");
        
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            int deviate=-1;
            if(a[i]<=n)     //how much pre existing array elements(1-n) have deviated from their position
            {
                if((i+1)>=a[i]) deviate=i+1-a[i];
                else deviate=(n+1-a[i])+i;
                if(deviate<n/2) de[deviate]++;
            }
            d[i]=deviate;
        }
        int max=0,sh=-1;
        for(int h=0;h<n/2;h++)
        if(de[h]>max) {max=de[h]; sh=h;}
 
        int q=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        for(i=0;i<q;i++)
        {
            s=bu.readLine().split(" ");
            int p=Integer.parseInt(s[0])-1, x=Integer.parseInt(s[1]),change=-1,flag=0;
            if(x<=n)    //if new element is <=n, then only can it contribute for identity
            {
                if((p+1)>=x) change=p+1-x;
                else change=(n+1-x)+p;
            }
 
            if(d[p]>=0 && d[p]<n/2)     //if deviation of current element at pos is in map, we need to reduce count
            {
                de[d[p]]--;
                if(d[p]==sh) flag=1;
            }
 
            d[p]=change;
            if(change>=0 && change<=n/2)      //it means less than n/2 shifts needed
            {
                de[change]++;
                if(de[change]>max) {max=de[change]; sh=change;} 
            }
 
            int min=n-de[0]; //no shifts necessary
            if(flag==1)
            {
                max=0;sh=-1;
                for(int h=0;h<n/2;h++)
                if(de[h]>0 && de[h]>max) {max=de[h]; sh=h; break;}
            }
            if(sh!=-1)
            min=sh+n-max>min?min:sh+n-max;
            sb.append(min+"\n");
        }
        System.out.print(sb);
    }
}
