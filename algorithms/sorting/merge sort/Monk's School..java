problem link-https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/practice-problems/algorithm/monks-school-4/?layout=old

import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i;
        ArrayList<Iden> a[]=new ArrayList[n];
        HashMap<String,Integer> hm=new HashMap<>();
        String te[]=new String[n];
        for(i=0;i<n;i++)
        {
            te[i]=bu.readLine();
            a[i]=new ArrayList<>();
            hm.put(te[i],i);
        }
        Arrays.sort(te);
        for(i=0;i<m;i++)
        {
            s=bu.readLine().split(" ");
            a[hm.get(s[0])].add(new Iden(s[1],Integer.parseInt(s[2])));
        }
        for(i=0;i<n;i++)
        {
            Collections.sort(a[i],new Comparator<Iden>(){
                public int compare(Iden a,Iden b)
                {
                    if(a.i>b.i) return 1;
                    else if(a.i==b.i && a.n.compareTo(b.n)>0) return 1;
                    else return -1;
                }
            });
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<n;i++)
        {
            sb.append(te[i]+"\n");
            int x=hm.get(te[i]);
            for(int j=0;j<a[x].size();j++)
            sb.append(a[x].get(j).n+" "+a[x].get(j).i+"\n");
        }
        System.out.print(sb);
    }

    static class Iden
    {
        String n; int i;
        Iden(String st,int no)
        {
            n=st;
            i=no;
        }
    }
}
