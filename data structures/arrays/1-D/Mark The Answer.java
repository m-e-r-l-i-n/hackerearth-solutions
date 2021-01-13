problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/mark-the-answer-1/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),x=Integer.parseInt(s[1]);
        int i,ans=0,a,skip=0;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a=Integer.parseInt(s[i]);
            if(a<=x) ans++;
            else skip++;
            if(skip==2) break;
        }
        System.out.print(ans);
    }
}
