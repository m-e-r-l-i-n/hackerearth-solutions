problem link-https://www.hackerearth.com/problem/algorithm/chandu-and-his-game/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),x[]=new int[k],y[]=new int[k],i;
        long m=0;
        s=bu.readLine().split(" ");
        for(i=0;i<k;i++)
        x[i]=Integer.parseInt(s[i])-1;
        s=bu.readLine().split(" ");
        for(i=0;i<k;i++)
        y[i]=Integer.parseInt(s[i])-1;

        for(i=0;i<k;i++)
        {
            int min=Integer.MAX_VALUE;
            min=Math.min(min,dist(x[i],y[i],0,0));
            min=Math.min(min,dist(x[i],y[i],n-1,0));
            min=Math.min(min,dist(x[i],y[i],0,n-1));
            min=Math.min(min,dist(x[i],y[i],n-1,n-1));
            m+=min;
        }
        System.out.print(m);
    }

    static int dist(int a,int b,int c, int d)
    {
        int ans=Math.abs(a-c)+Math.abs(b-d);
        return ans;
    }
}
