problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/moriarty-and-the-city/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),max=0,cur=0,c=0,k,i;
        StringTokenizer st=new StringTokenizer(bu.readLine());
        for(i=0;i<n;i++)
        {
            k=Integer.parseInt(st.nextToken());
            if(k==cur) c++;
            else
            {
                cur=k;
                max=Math.max(max,c);
                c=1;
            }
        }
        max=Math.max(max,c);
        System.out.print(max);
    }
}
