problem link-https://www.hackerearth.com/problem/algorithm/card-game-1/

import java.util.*;
import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int i,n=Integer.parseInt(bu.readLine());
            int d[]=new int[n],c[]=new int[n];
            String s[]=bu.readLine().split(" "),st[]=bu.readLine().split(" ");
            String first=bu.readLine();
            int mis=0;
            for(i=0;i<n;i++)
            {
                d[i]=Integer.parseInt(s[i]);
                c[i]=Integer.parseInt(st[i]);
                if(d[i]!=c[i]) mis++;                
            }
            if(mis<=2 && first.equals("Devu")) sb.append("Devu\n");
            else sb.append("Churu\n");
        }
        System.out.print(sb);
    }
}
