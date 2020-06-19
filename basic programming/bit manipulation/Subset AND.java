problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/subset-and-4/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int z=Integer.parseInt(s[0]),n=Integer.parseInt(s[1]),a[]=new int[32],i;
            int zr[]=new int[32];
            i=0;
            while(z!=0)
            {
                if((z&1)==1) zr[i]=1;
                z>>=1;
                i++;
            }
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                int k=Integer.parseInt(s[i]),p=0;
                while(k!=0)
                {
                    if((k&1)==0 && zr[p]==1) a[p]++;
                    k>>=1;
                    p++;
                }
                while(p<32) a[p++]++;
            }
            boolean flag=true;
            for(i=0;i<32;i++)
            if(zr[i]==1 && a[i]==0) {flag=false; break;}
            if(flag) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
    }
}
