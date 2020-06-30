//problem missing

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,k;
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i]);
            hm.put(k,hm.getOrDefault(k,0)+1);
        }
        for(int x:hm.keySet())
        if(hm.get(x)==1) al.add(x);
        int max=-1;
        for(i=0;i<al.size();i++)
        max=Math.max(al.get(i),max);
        System.out.print(max);
    }
}
