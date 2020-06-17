problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/supreme-subset-bb866a75/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,max=0,a[]=new int[n],maxx=0;
        s=bu.readLine().split(" ");
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            hm.put(a[i]%m,hm.getOrDefault(a[i]%m,0)+1);
        }
        Arrays.sort(a);
        StringBuilder sb=new StringBuilder();
        for(i=0;i<n;i++)
        {
            int k=a[i]%m;
            if(hm.get(k)>max) {max=hm.get(k); maxx=k;}
        }
        sb.append(max+"\n");
        for(i=0;i<n;i++)
        if(a[i]%m==maxx) sb.append(a[i]+" ");
        System.out.print(sb);
    }
}
