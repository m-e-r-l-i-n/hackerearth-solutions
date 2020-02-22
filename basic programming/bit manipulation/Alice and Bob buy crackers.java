problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/ram-and-shyam-buy-crackers-de722684/

import java.io.*;
import java.util.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int a[]=new int[n],i,j,sum=0;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            sum+=a[i];
        }
        printDistSum(a,sum);
    }
    
    static void printDistSum(int a[], int sum) 
    { 
        // dp[i][j] would be true if arr[0..i-1] has a subset with sum equal to j.
        int n=a.length;
        boolean[][] dp = new boolean[n+1][sum + 1]; 
  
        // There is always a subset with 0 sum 
        int i;
        ArrayList<Integer> al=new ArrayList<>();
        for(i=0;i<=n;i++) 
            dp[i][0]=true; 
  
        // Fill dp[][] in bottom up manner 
        for(i=1; i<=n; i++)  
        { 
            dp[i][a[i-1]]=true; 
            for (int j=1; j<=sum; j++)  
            { 
                // Sums that were achievable without current array element 
                if (dp[i-1][j]==true)  
                { 
                    dp[i][j]=true; 
                    dp[i][j+a[i-1]]=true; 
                } 
            } 
        } 
  
        //find from last row elements 
        for (i=0;i<=sum;i++) 
            if (dp[n][i]==true && i!=0 && i%2==0 && !al.contains(i)) 
                al.add(i);
        System.out.print(al.size());
    } 
}
        
