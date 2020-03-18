problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-reversed-numbers/description/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int a=Integer.parseInt(s[0]), b=Integer.parseInt(s[1]);
            a=reverse(a); b=reverse(b);
            sb.append(reverse(a+b)+"\n");
        }
        System.out.print(sb);
    }

    static int reverse(int n)
    {
        int no=0;
        while(n>0)
        {
            no=(10*no)+n%10;
            n=n/10;
        }
        return no;
    }
}
