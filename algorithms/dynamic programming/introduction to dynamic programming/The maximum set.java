import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int a,ans=1,l[]=new int[n],i;
            String s[]=bu.readLine().split(" ");
            //we have to find longest decreasing subsequence
            l[0]=-Integer.parseInt(s[0]);
            for(i=1;i<n;i++)
            {
                a=-Integer.parseInt(s[i]);  //taking negative values
                //if we do negative, then LDS problem gets converted to LIS
                if(a<l[0]) l[0]=a;
                else if(a>l[ans-1]) l[ans++]=a;
                else l[smallest(l,0,ans-1,a)]=a;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int smallest(int a[],int l,int r,int k)
    {
        int ans=r,m;
        while(l<=r)
        {
            m=(l+r)>>1;
            if(a[m]>=k)
            {
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
}
