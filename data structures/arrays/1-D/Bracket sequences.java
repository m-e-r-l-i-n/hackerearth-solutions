problem link-https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/bracket-sequence-1-40eab940/description/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char s[]=br.readLine().toCharArray();
        int n=s.length,op=0,cl=0,i,t=0,min=Integer.MAX_VALUE,c=0;
        for(i=0;i<n;i++)
        {
            if(s[i]=='(') {op++;t++;}
            else {cl++; t--;}
            if(t<min) {min=t; c=0;}
            if(t==min) c++;
        }
        if(op!=cl) {System.out.print(0); return;}
        System.out.print(c);
    }
}
