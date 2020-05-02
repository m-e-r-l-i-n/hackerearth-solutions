problem link-https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/snake-b0112afa/

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int a[][]=new int[n][3],i;
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            a[i][0]=Integer.parseInt(s[0]);
            a[i][1]=Integer.parseInt(s[1]);
            a[i][2]=i;
        }

        Arrays.sort(a, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0])
                {
                    if(o1[1]>=o2[1]) return 1;
                    else return -1;
                }
                else return -1;
            }});
        
        int ans[]=new int[n],j,ap=0; boolean l2r=true;
        for(i=0;i<n;i++)
        {
            j=i;
            ArrayList<Integer> al=new ArrayList<>();
            while(j<n && a[j][0]==a[i][0]) {al.add(j); j++;}
            i=j-1;
            if(l2r)
            {
                for(j=0;j<al.size();j++)
                    ans[a[al.get(j)][2]]=ap++;
                l2r=false;
            }
            else
            {
                for(j=al.size()-1;j>=0;j--)
                    ans[a[al.get(j)][2]]=ap++;
                l2r=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<n;i++)
        sb.append(ans[i]+"\n");
        System.out.print(sb);
    }
}
