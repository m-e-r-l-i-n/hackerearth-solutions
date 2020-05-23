problem link-https://www.hackerearth.com/problem/approximate/difsubsumarr-eb0fbef3/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,a[]=new int[n+1],j,p=nextprime(n);
        StringBuilder sb=new StringBuilder();
        
        for(i=0;i<=n;i++)
        a[i]=2*i*p+(i*i)%p;	//the only possible series is this
        for(i=1;i<=n;i++)
        sb.append(a[i]-a[i-1]+" ");
        System.out.print(sb);
    }

    static int nextprime(int n)
    {
        while(true) 
        {
            if(prime(n)) return n;
            n++;
        }
    }

    static boolean prime(int n)
    {
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i*i<=n;i+=6)
        if(n%i==0 || n%(i+2)==0) return false;
        return true;
    }
}
