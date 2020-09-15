problem link-https://www.hackerearth.com/problem/algorithm/prove-us-wrong/description/?layout=old

import java.io.*;
import java.math.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append(cal(n)+"\n");
        }
        System.out.print(sb);
    }

    static BigInteger cal(int n)
    {
        if(n==1) return BigInteger.ONE;
        /*
        i*10^m+x=(x*10+i)*n
        =>x*(10*n-1)=i*(10^m-n)
         */
        int M=10*n-1;
        boolean b[]=new boolean[M];
        int x=10,i;
        BigInteger w=BigInteger.valueOf(M);
        BigInteger ten=BigInteger.valueOf(10);
        for(BigInteger j=ten;; j=j.multiply(ten))
        {
            if(b[x]) return BigInteger.ZERO;
            b[x]=true;
            for(i=1;i<10;i++)
            {
                BigInteger t=j.subtract(j.valueOf(n)).multiply(j.valueOf(i));
                if(t.mod(w).signum()==0)
                {
                    t=t.divide(w);
                    if(t.compareTo(j)<0 && t.multiply(ten).compareTo(j)>=0) 
                        return t.multiply(ten).add(BigInteger.valueOf(i));
                }
            }
            x=x*10%M;
        }
    }
}
