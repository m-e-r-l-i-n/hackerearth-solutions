problem link-https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/many-bit-operation-9ff4912a/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]), q=Integer.parseInt(s[1]);
        int a[]=new int[n];
        StringBuilder sb=new StringBuilder();
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int c=Integer.parseInt(s[0]),l=Integer.parseInt(s[1])-1,r=Integer.parseInt(s[2])-1,x=0,i;
            if(c<4) x=Integer.parseInt(s[3]);
            switch(c)
            {
                case 1:for(i=l;i<=r;i++)
                a[i]=a[i]|x;
                break;
                case 2:for(i=l;i<=r;i++)
                a[i]=a[i]&x;
                break;
                case 3:for(i=l;i<=r;i++)
                a[i]=a[i]^x;
                break;
                case 4: long sum=0;
                for(i=l;i<=r;i++)
                sum+=a[i];
                sb.append(sum+"\n");
                break;
                case 5: long sum2=0;
                for(i=l;i<=r;i++)
                sum2^=a[i];
                sb.append(sum2+"\n");
                break;
            }
        }
        System.out.print(sb);
    }
}
