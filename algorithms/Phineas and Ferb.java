problem link-https://www.hackerearth.com/problem/algorithm/stone-game-a39dbbe7/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        String s[]=bu.readLine().split(" ");
        int i,c[][]=new int[n+1][31],a;
        for(i=0;i<n;i++)
        {
            a=Integer.parseInt(s[i]);
            int x=0;
            while(a>0)
            {
                if(a%2==1) c[i+1][x]++;
                x++;
                a>>=1;
            }
        }

        for(i=1;i<=n;i++)
        for(a=0;a<31;a++)
        c[i][a]+=c[i-1][a];

        int q=Integer.parseInt(bu.readLine());
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0])-1,r=Integer.parseInt(s[1]);
            boolean pos=true;
            for(i=0;i<31;i++)
            if((c[r][i]-c[l][i])%2==1) {pos=false; break;}
            if(pos) sb.append("Ferb\n");
            else sb.append("Phineas\n");
        }
        System.out.println(sb);
    }
}
