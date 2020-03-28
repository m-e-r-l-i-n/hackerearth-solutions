problem link-https://www.hackerearth.com/problem/algorithm/dislikes-and-party-567b9605/

import java.io.*;
import java.util.*;
import java.math.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,j,k,l,f[][]=new int[10][10];
        for(i=0;i<10;i++)
        {
            String s[]=bu.readLine().split(" ");
            for(j=0;j<10;j++)
            f[i][j]=Integer.parseInt(s[j]);
        }
        BigInteger tot=new BigInteger("0");
        tot=tot.valueOf(n).multiply(tot.valueOf(n-1)).divide(tot.valueOf(2));
        
        /*we just need to subtract the no handshakes from total handshakes
        total handshakes for n people is n(n-1)/2
        ans=total-no shakings*/

        int c=0;
        for(i=0;i<10;i++)
        {
            ArrayList<Integer> no=new ArrayList<>();
            for(j=1;j<10;j++) 
            {if(f[i][j]!=-1) no.add(f[i][j]);
            f[i][j]=-1;}
            for(k=0;k<10;k++)
            {
                if(k==i) continue;
                for(l=1;l<10;l++)
                if(f[k][l]==f[i][0])
                {if(!no.contains(f[k][0])) no.add(f[k][0]);
                f[k][l]=-1;}  
            }
            c+=no.size();
        }
        System.out.print(tot.subtract(tot.valueOf(c)));
    }
}
