problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/sorted-string/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s=bu.readLine();
            int c[][]=new int[26][2],i;
            for(i=0;i<26;i++)
            c[i][0]=i;

            for(i=0;i<s.length();i++)
            c[s.charAt(i)-'a'][1]++;

            Arrays.sort(c,new Comparator<int[]>(){
                public int compare(int o1[],int o2[])
                {
                    if(o1[1]>o2[1]) return 1;
                    else if(o1[1]==o2[1])
                    {
                        if(o1[0]>o2[0]) return 1;
                        else return -1;
                    }
                    else return -1;
                }});
            for(i=0;i<26;i++)
            for(int j=0;j<c[i][1];j++)
                sb.append((char)('a'+c[i][0]));
            sb.append("\n");    
        }
        System.out.print(sb);
    }
}
