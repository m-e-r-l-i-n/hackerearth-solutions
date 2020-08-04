problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/counting-strings/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            char s[]=bu.readLine().toCharArray();
            int i,n=s.length;
            ArrayList<Integer> al=new ArrayList<>();
            al.add(0);
            for(i=0;i<n;i++)
            if(s[i]=='a' || s[i]=='z') al.add(i);
            al.add(n);

            long c=0,d;
            for(i=1;i<al.size()-1;i++)
            {
                d=al.get(i)+1;
                c+=d;
                c+=d*(al.get(i+1)-al.get(i)-1);
            }
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
