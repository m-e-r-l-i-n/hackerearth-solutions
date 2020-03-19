problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/little-jhool-and-his-addiction-2-4/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=br.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),i;
            s=br.readLine().split(" ");
            int a[]=new int[n];
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            Arrays.sort(a);
            int min=1000000000,max=-1000000000;
            for(i=0;i<n/2;i++)
            {
                int diff=a[i]+a[n-i-1];
                if(diff>max) max=diff;
                if(diff<min) min=diff;
            }
            max=max-min;
            String st="";
            if(max>k) st="No more girlfriends!";
            else if(max==k) st="Lucky chap!";
            else st="Chick magnet Jhool!";
            sb.append(max+"\n"+st+"\n");
        }
        System.out.print(sb);
    }
}
