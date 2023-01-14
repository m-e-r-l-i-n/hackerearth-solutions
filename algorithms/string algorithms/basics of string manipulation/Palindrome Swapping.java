//problem link- https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/palindrome-swapping-37143cf3/

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String T = br.readLine();
         String S = br.readLine();

         boolean out_ = make_equal(T, S);
         System.out.println(out_ ? "YES" : "NO");

         wr.close();
         br.close();
    }
    static boolean make_equal(String T, String S){
       // Write your code here
        boolean result = true;
        int n=S.length(),i,c[]=new int[26];
        for(i=0;i<n;i++)
        {
            c[S.charAt(i)-'a']++;
            c[T.charAt(i)-'a']++;
            if(n-1-i!=i) 
            {
                c[S.charAt(n-1-i)-'a']++;
                c[T.charAt(n-1-i)-'a']++;
            }

            int j;
            for(j=0;j<26;j++) result&=c[j]%2==0;

            c[S.charAt(i)-'a']--;
            c[T.charAt(i)-'a']--;
            if(n-1-i!=i) 
            {
                c[S.charAt(n-1-i)-'a']--;
                c[T.charAt(n-1-i)-'a']--;
            }

        }
        return result;
    
    }
}
