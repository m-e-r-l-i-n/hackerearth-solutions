problem link-https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/k-palindrome-2c183be7/?layout=old

import java.io.*;
import java.util.*;
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            char s[]=bu.readLine().toCharArray();
            int i,n=s.length,k=Integer.parseInt(bu.readLine()),c=0;
            if((n%2==1 && k%2==0) || (n%2==0 && k%2==1)) {sb.append("-1\n"); continue;}
            ArrayList<Integer> di=new ArrayList<>();
            for(i=0;i<n/2;i++)
            di.add(Math.abs(s[i]-s[n-i-1]));
            if(n%2==1) c++;
            Collections.sort(di);

            for(i=0;i<di.size();i++)
            if(di.get(i)==0) c+=2;
            else break;
            if(c>=k) sb.append((c-k)/2+"\n");
            else
            {
                int ans=0;
                for(;i<di.size() && c!=k;i++,c+=2)
                ans+=di.get(i);
                sb.append(ans+"\n");
            }
        }
        System.out.print(sb);
    }
}
