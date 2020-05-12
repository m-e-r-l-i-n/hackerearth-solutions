problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/maximum-of-k-size-subarrays-deque/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),a[]=new int[n],i;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        for(i=0;i<=n-k;i++)
        {
            int max=0,j;
            for(j=i;j<i+k;j++)
            if(a[j]>max) max=a[j];
            sb.append(max+" ");
        }
        System.out.print(sb);
    }
}
