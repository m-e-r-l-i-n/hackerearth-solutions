problem link-https://www.hackerearth.com/problem/algorithm/difference-of-squares-69d144a5/?layout=old

import java.io.*;

class TestClass
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            int left=l,right=r;
            if(l%2==1) left--;
            int c=(right+1)/2-left/2;
            c+=right/4-left/4;
            if(l%4==0) c++;
            sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}
