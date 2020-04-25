problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/lets-shift-2-36d90caa/

import java.io.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {

        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            long n=Long.parseLong(s[0]);
            int d=Integer.parseInt(s[1]);int a[]=new int[16],i=0;
            char c=s[2].charAt(0);
            while(n!=0)
            {
                a[i++]=(int)(n&1);
                n>>=1;
            }
            String st="";
            for(i=15;i>=0;i--)
            st+=Integer.toString(a[i]);
            if(c=='L') st=st.substring(d)+st.substring(0,d);
            else st=st.substring(16-d)+st.substring(0,16-d);
            long ans=0; int cn=0;
            for(i=st.length()-1;i>=0;i--)
            ans+=(st.charAt(i)-48)*(long)Math.pow(2,cn++);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
