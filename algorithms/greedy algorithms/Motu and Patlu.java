problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/motu-and-patlu-1-ab612ad8/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,a[]=new int[n];
            long m[]=new long[n],p[]=new long[n],x=0;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                m[i]=x;
                x+=a[i];
            }
            x=0;
            for(i=n-1;i>=0;i--)
            {
                p[i]=x;
                x+=2*a[i];
            }
            int motu=0;
            for(i=0;i<n;i++)
            if(m[i]<=p[i]) motu++;
            sb.append(motu+" "+(n-motu)+"\n");
            String win="";
            if(motu>n-motu) win="Motu";
            else if(motu<n-motu) win="Patlu";
            else win="Tie";
            sb.append(win+"\n");
        }
        System.out.print(sb);
    }
}
