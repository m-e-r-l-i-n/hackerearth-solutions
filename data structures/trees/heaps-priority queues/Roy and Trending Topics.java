problem link-https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/roy-and-trending-topics-1/

import java.io.*;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i; long sc[][]=new long[n][3];
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            sc[i][0]=Integer.parseInt(s[0]);    //id goes to its column
            int z=Integer.parseInt(s[1]),p=Integer.parseInt(s[2]),l=Integer.parseInt(s[3])
            ,c=Integer.parseInt(s[4]),sh=Integer.parseInt(s[5]);
            sc[i][1]=50l*p+10l*c+5l*l+20l*sh; //calculate the new z
            sc[i][2]=sc[i][1]-z;  //store change
        }
        Arrays.sort(sc,new Comparator<long[]>()   //sort array according to given criteria
        { 
          public int compare(final long[] entry1,final long[] entry2) 
          { 
            if(entry1[2]>entry2[2]) return 1; 
            else if(entry1[2]==entry2[2] && entry1[0]>entry2[0]) return 1;
            else return -1; 
          } 
        });
        for(i=n-1;i>=n-5;i--)
        System.out.print(sc[i][0]+" "+sc[i][1]+"\n");  
    }
}
//note that this is a problem of priority queue, but can be solved easily using array and a comparartor o
