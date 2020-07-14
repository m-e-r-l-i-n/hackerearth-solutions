problem link-https://www.hackerearth.com/problem/algorithm/torneio-dos-torcedores/?layout=old

import java.io.*;
 
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int i,a[][]=new int[4][2],win=0;
        for(i=0;i<4;i++)
        {
            String s[]=bu.readLine().split(" ");
            a[i][0]=Integer.parseInt(s[0]); a[i][1]=Integer.parseInt(s[1]);
        }
        int a2[][]=new int[2][3];
        if(a[0][0]+a[0][1]>=a[1][0]+a[1][1])
        {
            a2[0][0]=1;
            a2[0][1]=a[0][0];
            a2[0][2]=a[0][1];
            a2[1][2]=a[1][1];   //losing team fans will support team that will play against winning side
        }
        else
        {
            a2[0][0]=2;
            a2[0][1]=a[1][0];
            a2[0][2]=a[1][1];
            a2[1][2]=a[0][1];
        }
 
        if(a[2][0]+a[2][1]>=a[3][0]+a[3][1])
        {
            a2[1][0]=3;
            a2[1][1]=a[2][0];
            a2[1][2]+=a[2][1];
            a2[0][2]+=a[3][1];
        }
        else
        {
            a2[1][0]=4;
            a2[1][1]=a[3][0];
            a2[1][2]+=a[3][1];
            a2[0][2]+=a[2][1];
        }
 
        if(a2[0][1]+a2[0][2]>=a2[1][1]+a2[1][2]) win=a2[0][0];
        else win=a2[1][0];
        System.out.print(win);
    }
}
