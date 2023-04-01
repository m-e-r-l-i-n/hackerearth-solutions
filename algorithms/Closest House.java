//https://www.hackerearth.com/problem/algorithm/closest-house-e9f3b2a8/

import java.util.*;
import java.io.*;

class TestClass
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int i,a[][]=new int[n][2],sumx=0,sumy=0;
            ArrayList<Integer> x=new ArrayList<>(),y=new ArrayList<>();
            for(i=0;i<n;i++)
            {
                String s[]=bu.readLine().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);

                x.add(a[i][0]); y.add(a[i][1]);
                sumx+=a[i][0]; sumy+=a[i][1];
            }

            Collections.sort(x); Collections.sort(y);
            int prex[]=new int[n],prey[]=new int[n];
            for(i=0;i<n;i++)
            {
                prex[i]=x.get(i);
                prey[i]=y.get(i);
                if(i>0)
                {
                    prex[i]+=prex[i-1];
                    prey[i]+=prey[i-1];
                }
            }

            int ans=Integer.MAX_VALUE;
            for(i=0;i<n;i++)
            {
                int cur,cx=binarys(x,a[i][0]),cy=binarys(y,a[i][1]);
                cur=(cx+1)*a[i][0]-prex[cx]; cur+=sumx-prex[cx]-(n-1-cx)*a[i][0];
                cur+=(cy+1)*a[i][1]-prey[cy]; cur+=sumy-prey[cy]-(n-1-cy)*a[i][1];
                ans=Math.min(ans,cur);
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int binarys(ArrayList<Integer> a,int k)
    {
        int l=0,r=a.size()-1,mid,ans=r;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a.get(mid)>=k)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
