problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/rubiks-square-2/?layout=old

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]),c=Integer.parseInt(s[2]);
        int i,j,k,a[][]=new int[n][n],rc[]=new int[n],cc[]=new int[n];
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<n;j++)
            a[i][j]=Integer.parseInt(s[j]);
        }
        if(r>0) 
        {
            s=bu.readLine().split(" ");
            for(i=0;i<r;i++)
            {
                k=Integer.parseInt(s[i])-1;
                rc[k]++;
                rc[k]%=n;
            }
            for(i=0;i<n;i++)
            {
                if(rc[i]==0) continue;
                int x[]=new int[n-rc[i]];
                for(j=0;j<n-rc[i];j++)
                x[j]=a[i][j];
                for(j=n-rc[i];j<n;j++)
                a[i][j-n+rc[i]]=a[i][j];
                for(j=rc[i];j<n;j++)
                a[i][j]=x[j-rc[i]];
            }
        }
        
        if(c>0) 
        {
            s=bu.readLine().split(" ");
            for(i=0;i<c;i++)
            {
                k=Integer.parseInt(s[i])-1;
                cc[k]++;
                cc[k]%=n;
            }
            for(i=0;i<n;i++)
            {
                if(cc[i]==0) continue;
                int x[]=new int[n-cc[i]];
                for(j=0;j<n-cc[i];j++)
                x[j]=a[j][i];
                for(j=n-cc[i];j<n;j++)
                a[j-n+cc[i]][i]=a[j][i];
                for(j=cc[i];j<n;j++)
                a[j][i]=x[j-cc[i]];
            }
        }

        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            sb.append(a[i][j]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
