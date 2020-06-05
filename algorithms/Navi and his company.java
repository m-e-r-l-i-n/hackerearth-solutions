problem link-https://www.hackerearth.com/problem/algorithm/navi-and-his-company-3/?layout=old

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
            int n=Integer.parseInt(bu.readLine());
            int em=0,un=0;
            while(n-->0)
            {
                String s=bu.readLine();
                if(!s.equals("New Project")) em+=Integer.parseInt(s);
                else
                {
                    if(em>0) em--;
                    else un++;
                }
            }
            sb.append(un+"\n");
        }
        System.out.print(sb);
    }
}
