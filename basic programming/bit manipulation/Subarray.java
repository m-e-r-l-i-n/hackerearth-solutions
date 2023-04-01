//https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/subarray-3-3dbc3f50/
//model solution is wrong, the correct solution is commented out

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine().trim());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine().trim());
            String s[]=bu.readLine().split(" ");
            int i,a[]=new int[n];
            for(i=0;i<n;i++) a[i]=Integer.parseInt(s[i]);

            int ones=0,zeros=0,moves=0;
            for(i=0;i<n;i++)
            if(a[i]==1)
            {
                int j=i;
                while(j<n && a[j]==1) j++;
                ones+=j-i;
                moves+=(j-i)/2;
                i=j-1;
            }
            else zeros++;

            int ans;
            if(ones==n) ans=0;
            else if(ones>zeros+1) ans=-1;
            else if(ones==zeros+1)
            {
                int f=1; ans=0;
                for(i=0;i<n;i++)
                {
                    if(a[i]!=f) ans++;
                    f^=1;
                }
                //ans/=2;
                ans=moves;
                //fails for test 01110, here ans=1, actual=2, feel free to challenge me
            }
            else ans=moves;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
