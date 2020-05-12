problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/hamiltonian-and-lagrangian/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        int i,k,max=0;
        String s[]=bu.readLine().split(" ");
        ArrayList<Integer> al=new ArrayList<>();
        for(i=n-1;i>=0;i--)
        {
            k=Integer.parseInt(s[i]);
            if(k>=max)
            {
                max=k;
                al.add(k);
            }
        }
        for(i=al.size()-1;i>=0;i--)
        sb.append(al.get(i)+" ");
        System.out.print(sb);
    }
}
