problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/approximate/palindromic-substrings-405e5398/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),i;
        char c[]=bu.readLine().toCharArray();
        StringBuilder sb=new StringBuilder();
        for(i=0;i<k-1;i++)
        sb.append(i+1+"\n");
        sb.append(n+"\n");
        ArrayList<Integer> cnt[]=new ArrayList[26];
        for(i=0;i<26;i++)
        cnt[i]=new ArrayList<>();
        for(i=0;i<k-1;i++)
        cnt[c[i]-'a'].add(i+1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(i=0;i<26;i++)
        {
            int j,sz=cnt[i].size();
            for(j=0;j<sz/2;j++)
            ans.add(cnt[i].get(j));
            for(j=sz/2;j<sz;j++)
            ans.add(0,cnt[i].get(j));
        }
        for(i=0;i<ans.size();i++)
        sb.append(ans.get(i)+" ");
        sb.append(k+"\n");
        System.out.print(sb);
    }
}
