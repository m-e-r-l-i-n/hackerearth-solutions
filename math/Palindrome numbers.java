problem link-https://www.hackerearth.com/problem/algorithm/kth-palindrome-45f48699/

import java.io.*;
import java.math.*;

class TestClass 
{
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder(); 
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]), i,j,l=s[0].length();
            long k=Long.parseLong(s[1]);
            
            char c[]=new char[l];
            for(i=0;i<(l+1)/2;i++)
            {c[i]=s[0].charAt(i);   //converting number to nearest palindrome(can be number itself)
            c[l-i-1]=c[i];}
            
            String st="";
            for(i=0;i<l;i++)
            st+=c[i];
            int n=Integer.parseInt(st);     //stores the palindrome 
            if(n==x && k==1)    //number is what is required
            {sb.append(x+"\n"); continue;}
            
            int pos=0;
            if(n>=x) k--;
            
            /*
            how do we fetch the rank of the current palindrome?
            (to note-0 is the palindrome with rank 1)
            if palindrome has even number of digits-put 1 in fromt of half of palindrome's digits
            eg-98766789 is at position 19876
            if palindrome has odd number of digits-add 1 to the first half of the palindrome including the central digit
            eg-515 is the 61st palindrome
            */
            
            if(l%2==0) st="1"+st.substring(0,l/2);
            else st=((st.charAt(0)-48)+1)+st.substring(1,l/2+1);
            pos=Integer.parseInt(st);           //check rank generation formula
            k=k+pos;    //we need palindrome at kth location
            
            /*
            now we need to generate the left half of palindrome whose rank is k(the upgraded one)
            how is it generated?
            n is described as the rank of p. The table below shows the ranking starting from n=1 where p=0.
            rank,n palindrome,p
                 1 0
                 2 1
                .. ..
                11 11
            Let t and k be the number of digits of n and p respectively.
            Let the string of digits of p, in the base B, be: pk-1 pk-2 ... p2 p1 p0
            The left half of the string of digits of p, that is pk-1 pk-2 ... p(k/2+1) p(k/2) is obtained to be
            = n - Bt-1 if n - Bt-1 >= Bt-2, or = n - Bt-2 otherwise
            The right half is obtained by copying the string of digits of the left half, in reverse order such that at the end p will indeed be a palindromic number. 
            Essentially:
            If left half is (n - Bt-2), then k = 2t - 3 and so p = pk-1 ... p(k/2+1) p(k/2) p(k/2+1) ... pk-1
            If left half is (n - Bt-1), < Bt-1, then k = 2t - 2 and so p = pk-1 ... p(k/2+1) p(k/2) p(k/2) p(k/2+1) ... pk-1
            If left half is (n - Bt-1), >= Bt-1, then k = 2t - 1 and so p = pk-1 ... p(k/2+1) p(k/2)p(k/2+1) ... pk-1
            Examples:
            If n = 357 and B = 10 then the left half of p is = 357 - 103-1 = 257. Since 257 > 103-1,we have k = 2(3)-1 = 5 and p = 25752.
            */
            
            st=Long.toString(k);
            int tt=st.length();
            int bt1=(int)Math.pow(10,tt-1),bt2=(int)Math.pow(10,tt-2),dig=0;
            long left=0;
            if(k-bt1>=bt2)       //check palindrome formula to see generation
            {
                left=k-bt1;
                if(left>=bt1) dig=2*tt-1;
                else dig=2*tt-2;
            }
            else 
            {
                left=k-bt2;
                dig=2*tt-3;
            }
            
            String le=Long.toString(left),ri="";
            for(i=0;i<dig-le.length();i++)
            ri=""+le.charAt(i)+ri;
            sb.append(le+ri+"\n");            
        }
        System.out.print(sb);
    }
}
