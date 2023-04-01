//https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/operation-dilemma-c26c704d/

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),l=Integer.parseInt(s[1]),k=Integer.parseInt(s[2]);
            s=bu.readLine().split(" ");
            int i,a[]=new int[n+1],b[]=new int[n+1];
            for(i=1;i<=n;i++) a[i]=Integer.parseInt(s[i-1]);
            s=bu.readLine().split(" ");
            for(i=1;i<=n;i++) b[i]=Integer.parseInt(s[i-1]);

            long suma[]=new long[n+1],sumb[]=new long[n+1];
            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]<o2[0]) return 1;
                    else return -1;
                }});
            for(i=1;i<=n;i++)
            {
                suma[i]=suma[i-1]+a[i];
                sumb[i]=sumb[i-1]-b[i];
                if(b[i]>0) pq.add(new int[]{b[i],i});
            }

            long ans=Long.MIN_VALUE,sumbit[]=new long[n+1],cnt[]=new long[n+1];
            int bno[]=new int[n+1];
            Arrays.fill(bno,-1);
            i=0;
            while(!pq.isEmpty()) bno[pq.poll()[1]]=i++;

            for(i=1;i<=n;i++)
            {
                if(bno[i]!=-1)
                {
                    update(cnt,bno[i],1,n);
                    update(sumbit,bno[i],b[i],n);
                }
                if(i-l<0) continue;
                if(bno[i-l]!=-1)
                {
                    update(cnt,bno[i-l],-1,n);
                    update(sumbit,bno[i-l],-b[i-l],n);
                }

                long cur=suma[i]-suma[i-l];
                cur+=sumb[i]-sumb[i-l];

                long cn=query(cnt,n-1),change;
                if(cn<=k) change=query(sumbit,n-1);
                else
                {
                    int u=0,v=n-1,mid,an=0;
                    while(u<=v)
                    {
                        mid=(u+v)>>1;
                        if(query(cnt,mid)>=k)
                        {
                            an=mid;
                            v=mid-1;
                        }
                        else u=mid+1;
                    }
                    change=query(sumbit,an);
                }
                ans=Math.max(ans,cur+change*2);
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static void update(long bit[],int i,int v,int n)
    {
        i++;
        while(i<=n)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }

    static long query(long bit[],int i)
    {
        i++;
        long s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
