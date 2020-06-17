problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/aniruddhas-queue-4/description/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),a[]=new int[n],i,day=0;
            String s[]=bu.readLine().split(" ");
            long sum=0,m=Long.parseLong(bu.readLine()),cur=0;
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                sum+=a[i];
                day++;
                if(sum>=m) break;
            }
            if(sum>=m) {sb.append(day+"\n"); continue;}
            cur=(m/sum)*sum;
            //System.out.print(cur+" ");
            if(m%sum==0) cur-=sum;
            day=0;
            for(i=0;i<n;i++)
            {
                cur+=a[i];
                day++;
                if(cur>=m) break;
            }
            sb.append(day+"\n");
        }
        System.out.print(sb);
    }
}
