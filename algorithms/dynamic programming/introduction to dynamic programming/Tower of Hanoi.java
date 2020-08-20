problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/tower-of-hanoi-17/?layout=old

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
            int i,a[][]=new int[n][2];
            for(i=0;i<n;i++)
            {
                StringTokenizer st=new StringTokenizer(bu.readLine());
                a[i][0]=Integer.parseInt(st.nextToken());
                a[i][1]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]>o2[0]) return 1;
                    else if(o1[0]==o2[0]) return o1[1]>=o2[1]?1:-1;
                    else return -1;
                }});

            long dp[]=new long[n];
            dp[0]=a[0][1];

            for(i=1;i<n;i++)
            {
                int j; long max=0;
                for(j=0;j<i;j++)
                if(a[j][0]<a[i][0] && a[j][1]<a[i][1]) max=Math.max(max,dp[j]);
                dp[i]=max+a[i][1];
            }
            long ans=0;
            for(i=0;i<n;i++) 
            ans=Math.max(ans,dp[i]);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
