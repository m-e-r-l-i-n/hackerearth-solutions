problem link-https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/zero-xor-e3085486/?layout=old

import java.io.*;
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i; long a[]=new long[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Long.parseLong(s[i]);
        
        ArrayList<Long> al=new ArrayList<>();
        ArrayList<Long> bl=new ArrayList<>();
        for(i=0;i<n/2;i++)
        al.add(a[i]);
        for(i=n/2;i<n;i++)
        bl.add(a[i]);
        
        HashMap<Long,Integer> ha=subsets(al.size(),al);
        HashMap<Long,Integer> hb=subsets(bl.size(),bl);
        long ans=0;
        if(ha.containsKey(0)) ans+=ha.get(0);
        if(hb.containsKey(0)) ans+=hb.get(0);
 
        for(long x:ha.keySet())
        if(hb.get(x)!=null) ans+=1l*ha.get(x)*hb.get(x);
        System.out.print(ans-1);
    }
 
    static HashMap<Long,Integer> subsets(int n,ArrayList<Long> al)
    {
        HashMap<Long,Integer> hm=new HashMap<>();
        int i,j;
        for(i=0;i<(int)Math.pow(2,n);i++)
        {
            long t=0;
            int d=i,c=0;
            char s[]=new char[21];
            Arrays.fill(s,'0');
            while(d!=0)
            {
                if((d&1)==1) s[c++]='1';
                else s[c++]='0';
                d>>=1;
            }
            for(j=0;j<n;j++)
            if(s[j]=='1') t^=al.get(j);
 
            hm.put(t,hm.getOrDefault(t,0)+1);
        }
        return hm;
    }
}
