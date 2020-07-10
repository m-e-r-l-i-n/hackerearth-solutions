problem link-https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/shantam-and-richness-1/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String st[]=bu.readLine().split(" ");
            int n=Integer.parseInt(st[0]),m=Integer.parseInt(st[1]);
            st=bu.readLine().split(" ");
            int l=Integer.parseInt(st[0]),r=Integer.parseInt(st[1]),p=Integer.parseInt(st[3]),q=Integer.parseInt(st[4]),s=Integer.parseInt(st[5]);
            int pl=0,pr=0,i;
            long c=Integer.parseInt(st[2]),pc=0,a[]=new long[n+1];

            for(i=0;i<m;i++)
            {
                if(i!=0)
                {
                    l=(pl*p+pr)%n+1;
                    r=(pr*q+pl)%n+1;
                    c=(pc*s)%1000000+1;
                }
                if(l>r) l=l^r^(r=l);
                a[l-1]+=c;
                a[r]-=c;
                pl=l; pr=r; pc=c;
            }
            long max=0,mp=0;
            for(i=1;i<=n;i++)
            a[i]+=a[i-1];
            for(i=0;i<n;i++)
            if(a[i]>max) {max=a[i]; mp=i;}
            sb.append(mp+1+" "+max+"\n");
        }
        System.out.print(sb);
    }
}
