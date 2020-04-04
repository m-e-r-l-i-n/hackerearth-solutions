problem link-https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/water-flow-4-38cea6c6/

//in spite of this being a dfs problem, dfs is not needed to solve the problem

import java.io.*;
class TestClass 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i;
        String s="";
        for(i=0;i<n-1;i++)
        s=bu.readLine();
        String st[]=bu.readLine().split(" ");
        int l=0,max=0,startm=-1,endm=-1;
        for(i=0;i<n;i++)
        if(st[i].equals("0")) l++;
        else
        {
            l++;
            if(l>max) {max=l; startm=i-l;}
            l=0;
        }
        l++;
        if(l>max) {max=l; startm=i-l;}
        if(startm>=0 && st[startm].equals("1")) max++;
        System.out.print(max);
    }
}
