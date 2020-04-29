problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/ranged-xor/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine()),z=0,o=0,i,a[][]=new int[n+1][2],k;

        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            k=s[i].charAt(0);
            if(k=='0') z++;
            else o++;
            a[i+1][0]=z;
            a[i+1][1]=o;
        }
        
        int q=Integer.parseInt(bu.readLine());
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            int un=a[r][0]-a[l-1][0],x=(a[r][1]-a[l-1][1])%2;
            sb.append(x+" "+un+"\n");
        }
        System.out.print(sb);
    }
}
