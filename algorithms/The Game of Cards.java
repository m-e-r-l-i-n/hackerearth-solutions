problem link-https://www.hackerearth.com/problem/algorithm/the-game-of-cards/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),x=Integer.parseInt(s[1]);
        int i,a,ta=0,tb=0;
        ArrayList<Integer> al=new ArrayList<>(),bl=new ArrayList<>();
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a=Integer.parseInt(s[i]);
            if(a==x) ta++;
            else al.add(a);
        }
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a=Integer.parseInt(s[i]);
            if(a!=x) bl.add(a);
        }

        Collections.sort(al); Collections.sort(bl);
        int ans=0;
        boolean vis[]=new boolean[bl.size()+1];
        for(i=0;i<al.size();i++)
        {
            int j;
            for(j=0;j<bl.size();j++)
            if(bl.get(j)<al.get(i) && !vis[j])
            {
                vis[j]=true;
                ans++;
                break;
            }
        }
        ans+=Math.min(bl.size()-ans,ta);
        System.out.println(ans);
    }
}
