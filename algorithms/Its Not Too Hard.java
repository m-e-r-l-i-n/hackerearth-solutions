problem link-https://www.hackerearth.com/problem/algorithm/its-not-too-hard/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int a=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]);
        System.out.print(getmoves(a,b));
    }

    static int getmoves(int a,int b)
    {
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> m=new LinkedList<>();
        q.add(a); m.add(0);
        while(!q.isEmpty())
        {
            int p=q.poll(),mv=m.poll();
            if(p==b) return mv;
            mv++;
            if(p<b)
            {
                q.add(p*2);
                m.add(mv);
            }
            if(p%2==0)
            {
                q.add(p/2);
                m.add(mv);
                q.add(p+1);
                m.add(mv);
            }
            else
            {
                q.add(p-1);
                m.add(mv);
            }
        }
        return 0;
    }
}
