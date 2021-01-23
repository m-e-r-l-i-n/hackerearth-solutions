problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/tournament-and-ranks-67cd4b7e/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
            int i,a[]=new int[n];
            HashMap<Integer,Integer> hm=new HashMap<>();
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                hm.put(a[i],hm.getOrDefault(a[i],0)+1);
            }
            
            while(q-->0)
            {
                s=bu.readLine().split(" ");
                i=Integer.parseInt(s[0])-1;
                int x=Integer.parseInt(s[1]);
                if(hm.get(a[i])==1) hm.remove(a[i]);
                else hm.put(a[i],hm.get(a[i])-1);
                a[i]=x;
                hm.put(x,hm.getOrDefault(x,0)+1);
                sb.append(hm.size()+1+"\n");
            }
        }
        System.out.print(sb);
    }
}
