problem link-https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/chessboard-2-8f06e380/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int x1=Integer.parseInt(s[0]),y1=Integer.parseInt(s[1]);
            s=bu.readLine().split(" ");
            int x2=Integer.parseInt(s[0]),y2=Integer.parseInt(s[1]);
            if(x1==x2 && y1==y2) sb.append("SECOND\n");
            else if(Math.abs(x1-x2)<2 && Math.abs(y1-y2)<2) sb.append("FIRST\n");
            else sb.append("DRAW\n");
        }
        System.out.print(sb);
    }
}
