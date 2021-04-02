import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        long f=1,M=1000000007;
        while(n>0)
        {
            f=f*n%M;
            n--;
        }
        System.out.println(f);
    }
}
