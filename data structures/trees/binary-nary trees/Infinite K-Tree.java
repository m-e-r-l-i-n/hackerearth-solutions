//problem link-https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/infinite-k-tree-e6841f51/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int k=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
        HashMap<Long,Long> hm=new HashMap<>();
        Stack<Long> pu=new Stack<>(),pv=new Stack<>();
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int t=Integer.parseInt(s[0]);

            long u=Long.parseLong(s[1]),v=Long.parseLong(s[2]);
            getpath(pu,u,k); getpath(pv,v,k);

            while(!pu.isEmpty() && !pv.isEmpty() && (long)pu.peek()==(long)pv.peek())
            {
                pu.pop();
                pv.pop();
            }

            if(t==1)
            {
                long ans=0;
                while(!pu.isEmpty()) ans+=hm.getOrDefault(pu.pop(),0l)+1;
                while(!pv.isEmpty()) ans+=hm.getOrDefault(pv.pop(),0l)+1;
                sb.append(ans+"\n");
            }
            else
            {
                int w=Integer.parseInt(s[3]);
                while(!pu.isEmpty()) hm.put(pu.peek(),hm.getOrDefault(pu.pop(),0l)+w);
                while(!pv.isEmpty()) hm.put(pv.peek(),hm.getOrDefault(pv.pop(),0l)+w);
            }
        }
        System.out.print(sb);
    }

    static void getpath(Stack<Long> ans,long u,int k)
    {
        while(u!=0)
        {
            ans.add(u);
            u/=k;
        }
    }
}
