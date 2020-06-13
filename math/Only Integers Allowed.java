problem link-https://www.hackerearth.com/problem/algorithm/integers-only-allowed/

/*question is-
given n points in cyclic order, find the number of coordinate points lying strictly inside the polygon*/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,x[]=new int[n],y[]=new int[n];
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            x[i]=Integer.parseInt(s[0]);
            y[i]=Integer.parseInt(s[1]);
        }

        /*Pick's theorem-
        total polygon area S=number of coordinate points inside poygon I + number of points on its boundaries B/2 -1
        => I=S-(B/2)+1
        */

        double s=0;
        int j=n-1;
        for(i=0;i<n;i++)
        {
            s+=1l*(x[j]+x[i])*(y[j]-y[i]);
            j=i;
        }
        s=Math.abs(s/2);

        double b=n;
        for(i=0;i<n;i++)
        {
            int dx=x[i]-x[(i+1)%n], dy=y[i]-y[(i+1)%n];
            b+=Math.abs(gcd(dx,dy))-1;
        }
        b/=2;
        System.out.print((long)(s-b+1));
    }

    static int gcd(int a,int b)
    {
        if(a<b) a=a^b^(b=a);
        int t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
