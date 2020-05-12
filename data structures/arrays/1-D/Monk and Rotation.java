problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-rotation-3/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
            k%=n;
            int ans[]=new int[n],i,p=0;
            s=bu.readLine().split(" ");
            for(i=n-k;i<n;i++)
            ans[p++]=Integer.parseInt(s[i]);
            for(i=0;i<n-k;i++)
            ans[p++]=Integer.parseInt(s[i]);
            for(i=0;i<n;i++)
            sb.append(ans[i]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
