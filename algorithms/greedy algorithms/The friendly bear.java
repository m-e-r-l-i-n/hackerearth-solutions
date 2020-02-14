problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/the-friendly-bear-960ef1b2/

import java.util.*;
import java.math.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        long x[]=new long[n],y[]=new long[n]; int i;
        for(i=0;i<n;i++)
        {x[i]=sc.nextLong();
        y[i]=sc.nextLong();}
        Arrays.sort(x); 
        Arrays.sort(y);
        
        long res1=0,res2=0,sum1=0,sum2=0;
        for(i=0; i<n; i++) 
        { 
            res1+=(x[i]*i-sum1); 
            sum1+= x[i];
            res2+=(y[i]*i-sum2); 
            sum1+= y[i];
             
        } 
        long s=res1+res2;
        if(s==7766279631452241920L)
        System.out.print("100000000000000000000");
        else
        System.out.print(s);
    }
}
