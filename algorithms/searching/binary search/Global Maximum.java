problem link-https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/global-maximum/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i,a[]=new int[n],m;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        m=Integer.parseInt(bu.readLine());

        int l=0,r=a[n-1]-a[0],mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(possible(a,mid,m))
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        System.out.print(ans);
    }

    static boolean possible(int a[],int k,int m)
    {
        int i,n=a.length,prev=a[0],c=1;
        for(i=1;i<n;i++)
        if(a[i]-prev>=k)
        {
            prev=a[i];
            c++;
            if(c==m) return true;
        }
        return false;
    }
}
