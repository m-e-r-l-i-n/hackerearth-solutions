problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/practice-problems/algorithm/lucky-string-jackpot-1/description/

import java.io.*;
import java.math.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine());
            
            /*make two trees as following
            4              |            5
            44    |45      |    54 |    55
            444 445 454 455|544 545 554 555
            
            now see the cases for jackpot string(we concatenate the 1st 2 nodes of each level)-
            45 44445 444445
            therefore, the palindromes are 4 444 44444 

            length of each level will be 1 + 1+1*2^1 + 1+2+2*2^2 + 11+3*2^3 + ...(^-power)
            this is because at level 2-length of each node/leaf will be 2 and the net contribution will be 2*(2^2)*/
             

            int i=1; long ctr=1;
            while(true)
            {
                ctr+=(long)Math.pow(2,i)*i;
                if(ctr>n) break;
                i++;
            }
            long diff=n-(long)Math.pow(2,i-1);
            if(diff>=(2*i-1)|| diff==0)
            diff=2*i-1;
            sb.append(diff+"\n");
        }
        System.out.print(sb);
    }
}
