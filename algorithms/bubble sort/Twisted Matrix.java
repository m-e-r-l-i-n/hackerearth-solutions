problem link-https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/twisted-matrix/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int a[]=new int[n*n],i,j,k=0;
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split("\\s+");
            for(j=0;j<n;j++)
            a[k++]=Integer.parseInt(s[j]);
        }
        
        
        for(i=0;i<n*n;i++)      //bubble sort
        for(j=0;j<n*n-i-1;j++)
        if(a[j]>a[j+1])
        a[j+1]=a[j+1]^a[j]^(a[j]=a[j+1]);
        
        int m[][]=new int[n][n],top=0,left=0,bottom=n-1,right=n-1;
        k=0;
        
        while(true)
        {
            if(left>right) break;       //breaking point
            
            for(i=left;i<=right;i++)    //in clockwise, we first fill top
            m[top][i]=a[k++];
            top++;          //since top row is filled, top is changed so that new elements are filled in next row
        
            for(i=top;i<=bottom;i++)    //then right is filled
            m[i][right]=a[k++];
            right--;        //same as in top, and same for rest
        
            for(i=right;i>=left;i--)    //bottom is being filled here
            m[bottom][i]=a[k++];
            bottom--;
        
            for(i=bottom;i>=top;i--)    //finally left is being filled
            m[i][left]=a[k++];
            left++;
        }
        
        for(i=0;i<n;i++)
        {for(j=0;j<n;j++)
        System.out.print(m[i][j]+" ");
        System.out.println();}
    }
}
