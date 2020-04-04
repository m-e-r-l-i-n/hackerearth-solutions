problem link-https://www.hackerearth.com/practice/algorithms/graphs/graph-representation/practice-problems/algorithm/special-graph-2-3b2bf33c/

//no need to know graphs to solve it, just analyze the question

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[] )throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int pr[]=new int[1000001],c[]=new int[1000001],i,j,co=0;
        for(i=2;i*i<=1000000;i++)
        {
            if(pr[i]==0)
            for(j=2*i;j<=1000000;j+=i)
            pr[j]=1;
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(i=2;i<=1000000;i++)
        {if(pr[i]==0) {al.add(i); co++;}
        c[i]=co;}
        
        int q=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(q-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(c[n]+"\n");
        }
        System.out.print(sb);
    }
}
