problem link-https://www.hackerearth.com/problem/algorithm/forming-regular-polygon-ca4d563a/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i,k;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(s[i]);
            hm.put(k,hm.getOrDefault(k,0)+1);
        }
        long ans=0,M=1000000007;
        for(int x:hm.keySet())
        if(hm.get(x)>2)
        {
            long v=hm.get(x),val=pow(v)-(1+v+v*(v-1)/2)%M;
            val+=M;
            val%=M;
            ans=ans+val;
            ans%=M;
        }
        System.out.print(ans);
    }

    static long pow(long k)
    {
        long res=1,a=2,M=1000000007;
        while(k!=0)
        {
            if(k%2==1) res=res*a%M;
            k>>=1;
            a=a*a%M;
        }
        return res;
    }
}
