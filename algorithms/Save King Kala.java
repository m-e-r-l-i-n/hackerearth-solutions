import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int t=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        int i,j,N=100000,p[]=new int[N+1];
        for(i=2;i<=N;i++)
        if(p[i]==0)
        for(j=i;j<=N;j+=i) p[j]=i;

        ArrayList<Integer> c[]=new ArrayList[(N/10)+1];
        long M=10000000000037l;
        ArrayList<Long> sum[]=new ArrayList[(N/10)+1];
        for(i=0;i<=N/10;i++)
        {
            c[i]=new ArrayList<>();
            sum[i]=new ArrayList<>();
            sum[i].add(0l);
        }
        c[1].add(1); sum[1].add(1l);
        for(i=2;i<=N;i++)   //note that k will be odd, so we need only odd factors ie, squares
        {
            int x=i,f=1;
            long add=1;
            while(x!=1)
            {
                int pr=p[x],cn=0;
                while(x%pr==0)
                {
                    x/=pr;
                    cn++;
                }
                cn*=2;  //squaring
                f*=cn+1;

                cn*=m;
                while(cn>0)     //(i*i)^m
                {
                    cn--;
                    add=add*pr%M;
                }
            }
            if(f<=(N/10))
            {
                c[f].add(i);
                sum[f].add((sum[f].get(sum[f].size()-1)+add)%M);
            }
        }

        while(t-->0)
        {
            s=bu.readLine().split(" ");
            long a=Long.parseLong(s[1]),b=Long.parseLong(s[2]);
            int k=Integer.parseInt(s[0]),u=lower(c[k],a-1),v=lower(c[k],b);
            long ans=sum[k].get(v)-sum[k].get(u);
            ans%=M;
            ans=(ans+M)%M;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }

    static int lower(ArrayList<Integer> a,long k)
    {
        if(a.size()==0) return 0;
        int l=0,r=a.size()-1,mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)>>1;
            long v=1l*a.get(mid)*a.get(mid);
            if(v<=k)
            {
                ans=mid+1;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
}
