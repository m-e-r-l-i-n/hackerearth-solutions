problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/can-you-solve-it/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,k;
            String s[]=bu.readLine().split(" ");
            int ma1=Integer.MIN_VALUE,ma2=ma1,mi1=Integer.MAX_VALUE,mi2=mi1;
            for(i=0;i<n;i++)
            {
                k=Integer.parseInt(s[i]);
                if(k+i<mi1) mi1=k+i;
                if(k+i>ma1) ma1=k+i;
                if(k-i>ma2) ma2=k-i;
                if(k-i<mi2) mi2=k-i;
            }
            sb.append(Math.max(ma1-mi1,ma2-mi2)+"\n");
        }
        System.out.print(sb);
    }
}
