problem link-https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/i-will-find-you-and-correct-you-5/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine().trim());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            HashMap<String,Integer> hm=new HashMap<>();
            for(String st:s)
            {
                int v=hm.getOrDefault(st,0);
                hm.put(st,v+1);
            }
            sb.append(hm.size()+"\n");
        }
        System.out.print(sb);
    }
}
