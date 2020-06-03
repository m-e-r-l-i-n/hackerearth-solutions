problem link-https://www.hackerearth.com/problem/algorithm/smallest-positive-integer/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        if(n==0) {System.out.print(10); return;}
        int i;
        ArrayList<Integer> p=new ArrayList<>();
        while(true)
        {
            int no=n;
            for(i=2;i*i<=n;i++)
            if(n%i==0) 
            while(n%i==0) {n/=i; p.add(i);}
            if(n>1 && n<10) p.add(n);
            if(n<10) break;
            n=no+1000000007;
            p=new ArrayList<>();
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int cur=1;
        for(i=0;i<p.size();i++)
        if(cur*p.get(i)<10) cur*=p.get(i);
        else {ans.add(cur); cur=p.get(i);}
        if(cur!=1) ans.add(cur);
        Collections.sort(ans);
        StringBuilder sb=new StringBuilder();
        for(i=0;i<ans.size();i++)
        sb.append(ans.get(i));
        System.out.print(sb);
    }
}
