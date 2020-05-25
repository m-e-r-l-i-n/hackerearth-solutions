problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/monk-and-the-box-of-cookies/?layout=old

import java.io.*;

class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int c[]=new int[32],i;
            int q=Integer.parseInt(bu.readLine());
            while(q-->0)
            {
                i=0;
                int n=Integer.parseInt(bu.readLine());
                while(n!=0)
                {
                    if((n&1)==1) c[i]++;
                    n>>=1;
                    i++;
                }
            }
            int max=0,maxp=0;
            for(i=0;i<32;i++)
            if(c[i]>max) {max=c[i]; maxp=i;}
            sb.append(maxp+"\n");
        }
        System.out.print(sb);
    }
}
