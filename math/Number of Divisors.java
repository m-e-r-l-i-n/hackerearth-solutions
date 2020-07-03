problem link-https://www.hackerearth.com/problem/algorithm/number-of-divisors-5/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        HashMap<Long,Long> hm=new HashMap<>();
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine()),i,c=0;
            if(hm.get(n)!=null) {sb.append(hm.get(n)+"\n"); continue;}
            for(i=1;i*i<=n;i++)
            if(n%i==0)
            {
                c++;
                if(n/i!=i) c++;
            }
            hm.put(n,c);
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
