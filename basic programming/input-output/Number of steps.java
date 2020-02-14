problem link-https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/make-all-equal-90a21ab2/

import java.io.*;
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        String s[]=bu.readLine().split(" ");
        String st[]=bu.readLine().split(" ");
        int i,a[]=new int[n],b[]=new int[n],min=500000;
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            b[i]=Integer.parseInt(st[i]);
            if(a[i]<min) min=a[i];
        }
        boolean bool=false;int max=Integer.MAX_VALUE,k;
        for(k=0;k<=min;k++)
        {int steps=0,f=0;
        for(i=0;i<n;i++)
        {
            int diff=a[i]-k;
            if(b[i]==0)
            {if(diff>0)
            {f=1;break;}}
            else if((diff%b[i])==0)
            steps=steps+(diff/b[i]);
            else
            {f=1;break;}
        }
        if(f==0)
        {max=(int)Math.min(steps,max);
        bool=true;}
        }
        if(bool)
        System.out.print(max);
        else
        System.out.print(-1);
        
    }
}
