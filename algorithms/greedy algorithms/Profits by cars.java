problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/jetha-and-cars-2d835131/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,k; long sum=0;
            HashMap<Integer,Integer> hm=new HashMap<>();
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                k=Integer.parseInt(s[i]);
                hm.put(k,hm.getOrDefault(k,0)+1);
            }
            for(int x:hm.keySet())
                sum+=x;
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}
