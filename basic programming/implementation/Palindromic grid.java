problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/palindromic-grid-e55f3027/description/

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String st[]=bu.readLine().split(" ");
            int i,j,n=Integer.parseInt(st[0]),m=Integer.parseInt(st[1]);
            int c[]=new int[26];
            for(i=0;i<n;i++)
            {
                String s=bu.readLine();
                for(j=0;j<m;j++)
                c[s.charAt(j)-97]++;
            }

            int flag=0;
            int four=0,rfour=(n/2)*(m/2),rtwo=0,two=0,one=0;   //rfour is total number of required quadruples
            for(i=0;i<26;i++)
            {four+=c[i]/4;
            c[i]%=4;}
            if(four<rfour) flag=1;  //available fours <required
            
            if(flag==0)
            {
                four-=rfour;
                if(n%2==1) rtwo+=m/2;   //note the twist here   
                if(m%2==1) rtwo+=n/2;   //number of pairs required
                two=four*2;    
                for(i=0;i<26;i++)
                {two+=c[i]/2;
                c[i]%=2;}
                if(two<rtwo) flag=1;
            }
            
            if(flag==0)
            {
                two-=rtwo;  
                one=two*2;     
                int rone=0;
                if(n%2==1 && m%2==1) rone=1;//number of single characters needed
                for(i=0;i<26;i++)
                one+=c[i];
                if(one<rone) flag=1;
            }
            
            if(flag==0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
