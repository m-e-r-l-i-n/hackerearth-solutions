problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/make-them-equal-ac0bab4a/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            char a[]=bu.readLine().toCharArray();
            char b[]=bu.readLine().toCharArray();
            int i,c[][]=new int[2][26];
            for(i=0;i<n;i++)
            {
                if(a[i]!='?') c[0][a[i]-'a']++;
                if(b[i]!='?') c[1][b[i]-'a']++;
            }

            int d=0;
            for(i=0;i<26;i++)
            d+=Math.abs(c[0][i]-c[1][i]);
            if(d<3) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
