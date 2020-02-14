problem link-

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(bu.readLine()); 
        int i,j;
        String s=bu.readLine();
        int b[][]=new int[s.length()+1][26];
        for(i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            for(j=0;j<26;j++)
            {
                if((int)ch==(97+j))
                b[i+1][j]=b[i][j]+1;
                else b[i+1][j]=b[i][j];
            }
        }
        
        while(q-->0)
        {
            String st[]=bu.readLine().split(" ");
            int l=Integer.parseInt(st[0]),r=Integer.parseInt(st[1]),c=0;
            if(l>r)
            {System.out.println("Impossible");
            continue;}
            if(l==r)
            {System.out.println("Possible");
            continue;}
            boolean val=true;
            if(l!=r)
            for(i=0;i<26;i++)
            if((b[r][i]-b[l-1][i])%2==1)
            {val=false;c++;}
            if(val)
            System.out.println("Possible");
            else if(c==1)
            System.out.println("Possible");
            else System.out.println("Impossible");
        }
}}
