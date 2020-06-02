problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/state-space-reduction/practice-problems/algorithm/bytelandian-gold-coins/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        System.out.print(maxim(n));
    }
    static HashMap<Long,Long> hm=new HashMap<>();
    static long maxim(long n)
    {
        if(n==0) return 0;
        else if(hm.get(n)!=null) return hm.get(n);
        else 
        {
            long v=maxim(n/2)+maxim(n/3)+maxim(n/4);
            hm.put(n,Math.max(n,v));
            return hm.get(n);
        }
    }
}
