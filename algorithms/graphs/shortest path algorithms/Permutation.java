problem link-https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/permutations/description/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(bu.readLine());
        String s[]=bu.readLine().split(" ");
        int i,a[]=new int[k],pos[]=new int[k+1],g[][]=new int[k][k];
        for(i=0;i<k;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            pos[a[i]]=i;
        }

        for(i=0;i<k;i++)
        {
            String st=bu.readLine();
            for(int j=0;j<k;j++)
            if(st.charAt(j)=='Y') g[i][j]=1;
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<k;i++)
        {
            boolean vis[]=new boolean[k+1];
            int cur=Integer.MAX_VALUE;
            cur=dfs(cur,a,g,i,vis);
            choose[pos[cur]]=true;
            sb.append(cur+" ");
        }
        System.out.print(sb);
    }

    static boolean choose[]=new boolean[102];
    static int dfs(int ans,int a[],int g[][],int n,boolean vis[])
    {
        vis[n]=true;
        if(!choose[n]) ans=Math.min(ans,a[n]);
        for(int i=0;i<g[0].length;i++)
        if(g[n][i]==1 && !vis[i]) ans=Math.min(ans,dfs(ans,a,g,i,vis));
        return ans;
    }
}
