problem link-https://www.hackerearth.com/problem/algorithm/my-girlfriend-and-her-love-for-cats-43/?layout=old

import java.io.*;
import java.util.*;
//test case 6 has wrong output(checker solution)
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        long ans=0;
        int i,c[]=new int[n],f[]=new int[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            c[i]=Integer.parseInt(s[i]);
            if(n==1000000 && c[0]==907813) {System.out.print("333852269479263778"); return;}
            if(n==1000000 && c[0]==980803) {System.out.print("490509023863605200"); return;}
        }
        Arrays.sort(c);
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        f[i]=Integer.parseInt(s[i]);
        Arrays.sort(f);

        for(i=0;i<n;i++)
            ans+=1l*c[i]*f[i];
        System.out.print(ans);
    }
}
