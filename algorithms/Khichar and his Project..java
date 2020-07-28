problem link-https://www.hackerearth.com/problem/algorithm/khicchar-and-khicchar/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String a=bu.readLine(),b=bu.readLine(),c=bu.readLine(),d=bu.readLine();
            int e=Integer.parseInt(bu.readLine()),i;
            ArrayList<Integer> f=new ArrayList<>();
            for(i=1;i*i<=e;i++)
            if(e%i==0)
            {
                f.add(i);
                if(e/i!=i) f.add(e/i);
            }
            Collections.sort(f);
            int ans=1;
            for(i=1;i<f.size();i++)
            {
                int k=f.get(i),mod1=modulus(a,k),mod2=modulus(b,k),mod3=modulus(c,k),mod4=modulus(d,k);
                if(mod1==0 && mod2==0 && mod3==0 && mod4==0) ans=k;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int modulus(String s,int n)
    {
        int i,r=0;
        for(i=0;i<s.length();i++)
        r=(10*r+s.charAt(i)-'0')%n;
        return r;
    }
}
