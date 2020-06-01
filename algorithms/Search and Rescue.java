problem link-https://www.hackerearth.com/problem/algorithm/find-the-missing-one/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),a[]=new int[n],i;
        String s[]=bu.readLine().split(" ");
        a[0]=Integer.parseInt(s[0]); a[n-1]=Integer.parseInt(s[n-1]);
        int d=(a[n-1]-a[0])/n;
        if(d==0) {System.out.print(a[0]); return;}
        int mis=0;
        for(i=1;i<n-1;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            if(a[i]-a[i-1]!=d) {mis=a[i-1]+d; break;}
        }
        System.out.print(mis);
    }
}
