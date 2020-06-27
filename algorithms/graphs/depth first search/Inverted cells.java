problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/inverted-cells-83eae42d/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().trim().split("\\s+");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,j,a[][]=new int[n][m],p[][]=new int[n][m];
        for(i=0;i<n;i++)
        {
            String st=bu.readLine().trim();
            for(j=0;j<st.length();j++)
            if(st.charAt(j)=='.') a[i][j]=1;
        }
        
        for(i=0;i<m;i++)
            if(a[0][i]==0) break;
            else p[0][i]=1;
        for(i=0;i<n;i++)
            if(a[i][0]==0) break;
            else p[i][0]=1;

        for(i=1;i<n;i++)
        for(j=1;j<m;j++)
            if(a[i][j]==0) continue;
            else p[i][j]=Math.min(2,p[i-1][j]+p[i][j-1]);

        int ans[][]=new int[n][m];
        bfs(a,ans);
        bfs2(a,ans);

        if(p[n-1][m-1]==0)
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++) 
            if(ans[i][j]==2) sb.append("1 ");
            else sb.append("0 ");
            sb.append("\n");
        }
        else
        {
            int ans2[][]=new int[n][m];
            bfs3(a,ans,ans2);
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                if(ans2[i][j]==0) sb.append("1 ");
                else if(!rem.contains(ans2[i][j])) sb.append("1 ");
                else sb.append("0 ");
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static void bfs(int a[][],int an[][])
    {
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        boolean vis[][]=new boolean[a.length][a[0].length];
        qx.add(0); qy.add(0);
        while(!qx.isEmpty())
        {
            int px=qx.poll(),py=qy.poll();
            if(!vis[px][py])
            {
                an[px][py]++; vis[px][py]=true;
                if(a[px][py]==1)
                {
                    if(py+1<a[0].length) {qx.add(px); qy.add(py+1);}
                    if(px+1<a.length) {qx.add(px+1); qy.add(py);}
                }
            }
        }
    }

    static void bfs2(int a[][],int an[][])
    {
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        boolean vis[][]=new boolean[a.length][a[0].length];
        qx.add(a.length-1); qy.add(a[0].length-1);
        while(!qx.isEmpty())
        {
            int px=qx.poll(),py=qy.poll();
            if(!vis[px][py])
            {
                an[px][py]++; vis[px][py]=true;
                if(a[px][py]==1)
                {
                    if(py-1>=0) {qx.add(px); qy.add(py-1);}
                    if(px-1>=0) {qx.add(px-1); qy.add(py);}
                }
            }
        }
    }

    static ArrayList<Integer> rem=new ArrayList<>();
    static void bfs3(int a[][],int con[][],int an[][])
    {
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        Queue<Integer> l=new LinkedList<>();
        int lev[]=new int[1000000]; boolean vis[][]=new boolean[a.length][a[0].length];
        qx.add(0); qy.add(0); l.add(1);
        while(!qx.isEmpty())
        {
            int px=qx.poll(),py=qy.poll(),le=l.poll();
            if(a[px][py]==1 && !vis[px][py])
            {
                vis[px][py]=true;
                if(con[px][py]==2) {lev[le]++; an[px][py]=le;}
                if(px+1<a.length) {qx.add(px+1); qy.add(py); l.add(le+1);}
                if(py+1<a[0].length) {qx.add(px); qy.add(py+1); l.add(le+1);}
            }
        }
        for(int i=0;i<1000000;i++)
        if(lev[i]==1) rem.add(i);
    }
}
