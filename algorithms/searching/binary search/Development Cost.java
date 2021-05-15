//problem link-https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/dangerous-path-467b0dc7/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),q=Integer.parseInt(s[2]),k=Integer.parseInt(s[3]);
        int a[][]=new int[n][m],i,j;
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m;j++)
            a[i][j]=Integer.parseInt(s[j]);
        }

        int qr[][]=new int[q][4];
        for(i=0;i<q;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<4;j++)
            qr[i][j]=Integer.parseInt(s[j])-1;
        }

        int l=1,r=(int)1e9,mid,ans=r;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(a,qr,k,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        System.out.println(ans);
    }

    static boolean possible(int a[][],int qr[][],int k,int mid)
    {
        int n=a.length,m=a[0].length,q=qr.length,i,j;
        int vis[][]=new int[n][m],ptr=1,d[][]={{0,-1},{-1,0},{1,0},{0,1}};
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(vis[i][j]==0 && a[i][j]<=mid)
        {
            Queue<Integer> qx=new LinkedList<>(),qy=new LinkedList<>();
            qx.add(i); qy.add(j);
            vis[i][j]=ptr;
            while(!qx.isEmpty())
            {
                int x=qx.poll(),y=qy.poll();
                for(int dr[]:d)
                {
                    int tx=x+dr[0],ty=y+dr[1];
                    if(tx>=0 && tx<n && ty>=0 && ty<m && a[tx][ty]<=mid && vis[tx][ty]!=ptr)
                    {
                        vis[tx][ty]=ptr;
                        qx.add(tx); qy.add(ty);
                    }
                }
            }
            ptr++;
        }

        for(i=0;i<q;i++)
        {
            if(vis[qr[i][0]][qr[i][1]]==vis[qr[i][2]][qr[i][3]] && vis[qr[i][0]][qr[i][1]]!=0) k--;
            if(k==0) return true;
        }
        return false;
    }
}
