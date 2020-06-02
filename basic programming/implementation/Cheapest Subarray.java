problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/cheapest-subarray-d628cb65/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),i,min=Integer.MAX_VALUE,curr=0,prev=0;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                prev=curr;
                curr=Integer.parseInt(s[i]);
                if(i==0) continue;
                min=Math.min(min,curr+prev);
            }
            sb.append(min+"\n");
        }
        System.out.print(sb);
    }
}
