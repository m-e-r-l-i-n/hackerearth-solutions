problem link-https://www.hackerearth.com/problem/algorithm/pair-count-5/description/?layout=old

import java.io.*;
import java.util.*;
class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),d=Integer.parseInt(s[1]),i,j,a[]=new int[n],freq[]=new int[1000001];
        long c=0;
        s=bu.readLine().split(" ");
        ArrayList<Integer> f=new ArrayList<>(); //to store factors
 
        for(i=1;i*i<=d;i++) //finding factors in sqrt(n) time
        if(d%i==0)
        {
            f.add(i);
            if(d/i!=i) f.add(d/i);
        }
        
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            a[i]=gcd(d,a[i]);
            freq[a[i]]++;
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<f.size();i++)
        {
            int cnt=0,x=f.get(i);
            for(j=x;j<=1000000;j+=x)
            cnt+=freq[j];
            hm.put(f.get(i),cnt);
        }
        
	    for(i=0;i<n;i++) 
        {
		    int div=d/a[i];
            c+=hm.getOrDefault(div,0);
		    if(a[i]%div==0) --c;
	    }
	    c/=2;
        System.out.print(c);
    }
 
    static int gcd(int a,int b)
    {
        int t;
        if(a<b) a=a^b^(b=a);
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
