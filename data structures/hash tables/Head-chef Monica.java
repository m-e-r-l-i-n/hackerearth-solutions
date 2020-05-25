//problem missing

import java.io.*;
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i,a[]=new int[7];
        HashMap<Character,Integer> hm=new HashMap<>();
        hm.put('V',0); hm.put('N',1);
        hm.put('G',2); hm.put('T',3);
        hm.put('S',4); hm.put('B',5); hm.put('P',6);
        String s=bu.readLine();
        for(i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            a[hm.get(ch)]++;
        }
        int m=Integer.parseInt(bu.readLine());
        while(m-->0)
        {
            s=bu.readLine();
            char c1=s.charAt(0),c2=s.charAt(1),c3=s.charAt(2);
            long ways=1,M=1000000007;
            ways=ways*a[hm.get(c1)]%M; 
            ways=ways*a[hm.get(c2)]%M;  
            ways=ways*a[hm.get(c3)]%M;
            ways%=M;
            sb.append(ways+"\n");
            if(ways==0) continue;
            if(a[hm.get(c1)]>0) a[hm.get(c1)]--;
            if(a[hm.get(c2)]>0) a[hm.get(c2)]--;
            if(a[hm.get(c3)]>0) a[hm.get(c3)]--;
        }
        System.out.print(sb);
    }
}
