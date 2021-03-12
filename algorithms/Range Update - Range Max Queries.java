import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
        st=new long[4*n]; l=new long[4*n];
        int i,a;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a=Integer.parseInt(s[i]);
            update(0,n,i,i+1,a,1);
        }

        while(q-->0)
        {
            s=bu.readLine().split(" ");
            if(s[0].charAt(0)=='q')
            {
                int u=Integer.parseInt(s[1])-1,v=Integer.parseInt(s[2]);
                sb.append(query(0,n,u,v,1)+"\n");
            }
            else
            {
                int u=Integer.parseInt(s[1]),v=Integer.parseInt(s[2]),x=Integer.parseInt(s[3]);
                update(0,n,u-1,v,x,1);
            }
        }
        System.out.print(sb);
    }
    static long st[],l[];

    static void update(int ss,int se,int us,int ue,int v,int n)
    {
        st[n]+=l[n];
        if(ss+1!=se)
        {
            l[2*n]+=l[n];
            l[2*n+1]+=l[n];
        }
        l[n]=0;

        if(ss>=ue || se<=us) return;
        if(ss>=us && se<=ue)
        {
            l[n]+=v;
            st[n]+=l[n];
            if(ss+1!=se)
            {
                l[2*n]+=l[n];
                l[2*n+1]+=l[n];
            }
            l[n]=0;
            return;
        }

        int mid=(se+ss)/2;
        update(ss,mid,us,ue,v,2*n);
        update(mid,se,us,ue,v,2*n+1);
        st[n]=Math.min(st[2*n],st[2*n+1]);
    }

    static long query(int ss,int se,int qs,int qe,int n)
    {
        st[n]+=l[n];
        if(ss+1!=se)
        {
            l[2*n]+=l[n];
            l[2*n+1]+=l[n];
        }
        l[n]=0;

        if(ss>=qe || se<=qs) return Long.MAX_VALUE;
        if(ss>=qs && se<=qe) return st[n];
        int mid=(se+ss)/2;
        return Math.min(query(ss,mid,qs,qe,2*n),query(mid,se,qs,qe,2*n+1));
    }
}
