problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/approximate/kolmogorov-78780f09/?layout=old

import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i;
        String s=bu.readLine();
        s=possible(s,n);
        String ans=find(s),ans2=find3(s);
        if(ans2.length()<ans.length()) ans=ans2;
        int t=1;
        if(s.length()!=n) t=n/s.length();
        ans=maxreduce(ans);
        int lines=1+as.size();
        StringBuilder s2=new StringBuilder();
        for(char x:as.keySet())
        {
            s2.append(as.get(x)+"=\"");
            s2.append(x+"\"");
            s2.append("\n");
        }

        if(t!=1)
        {
            lines++;
            s2.append("a="+ans+"\n");
            s2.append("print(a*"+t+")");
        }
        else s2.append("print("+ans+")");
        sb.append(lines+"\n");
        sb.append(s2);
        String nl=null;
        System.out.println(nl);
        System.out.print(sb);
    }

    static String find(String s)
    {
        int i,n=s.length(),c=0; char cur=s.charAt(0);
        String ans="";
        Set<Integer> cn[]=new HashSet[256];
        for(i=0;i<256;i++) cn[i]=new HashSet<>();
        Set<Character> set=new HashSet<>();

        ArrayList<Pair> p=new ArrayList<>();
        for(i=0;i<s.length();i++)
        if(s.charAt(i)==cur) c++;
        else
        {
            cn[cur].add(c);
            set.add(cur);
            p.add(new Pair(cur,c));
            cur=s.charAt(i);
            c=1;
        }
        p.add(new Pair(cur,c));
        cn[cur].add(c);
        set.add(cur);
        String fin="",b=""; int l=0;

        Stack<Character> vbl=new Stack<>();
        for(i='a';i<='z'; i++) vbl.add((char)i);
        boolean r[]=new boolean[p.size()];
        int cl=n+9;
        for(i=0;i<p.size();i++)
        {
            int red=p.get(i).b;
            red-=8;
            red-=Integer.toString(p.get(i).b).length();
            if(i==0 || i==p.size()-1) red+=2;
            if(red>0) r[i]=true;
        }
        for(i=0;i<p.size();i++)
        {
            String cr="";
            if(ans.length()>0) cr+='+';
            cr+='"';

            int j=i;
            while(j<p.size() && !r[j]) {cr+=add(p.get(j).a,p.get(j).b); j++;}
            cr+='"';
            if(cr.length()>2) ans+=cr;
            if(j==p.size()) break;

            i=j;
            if(ans.length()>0) ans+='+';
            ans+="\""+p.get(i).a+"\""+"*"+p.get(i).b;
        }
        return ans;
    }

    static String add(char a,int b)
    {
        String n="";
        while(b>0)
        {
            n+=a;
            b--;
        }
        return n;
    }

    static String possible(String s,int n)
    {
        int i; String ans=s;
        for(i=1;i*i<=n;i++)
        if(n%i==0)
        {
            String g=find(s,i);
            if(!g.equals("-1") && g.length()<ans.length()) ans=g;
            if(n/i!=i && n/i!=n)
            {
                g=find(s,n/i);
                if(!g.equals("-1") && g.length()<ans.length()) ans=g;
            }
        }
        return ans;
    }
    static String find(String s,int l)
    {
        int i,n=s.length();
        String ans="";
        for(i=0;i<l;i++)
            ans+=s.charAt(i);

        for(i=l;i<n;i+=l)
        {
            boolean pos=true;
            for(int j=0;j<l;j++)
                if(ans.charAt(j)!=s.charAt(i+j)) {pos=false; break;}
            if(!pos) return "-1";
        }
        return ans;
    }

    static class Pair
    {
        char a; int b;
        Pair(char x,int y)
        {
            a=x;
            b=y;
        }
    }

    static String find3(String s)
    {
        int i,n=s.length(),c=0; char cur=s.charAt(0);
        String ans="";
        for(i=0;i<s.length();i++)
        if(s.charAt(i)==cur) c++;
        else
        {
            if(ans.length()!=0) ans+='+';
            ans+='"';
            if(c==1) {ans+=cur; ans+='"';}
            else if(c==2) {ans+=cur; ans+=cur; ans+='"';}
            else {ans+=cur; ans+='"'; ans+='*'; ans+=c;}
            cur=s.charAt(i);
            c=1;
        }
        if(ans.length()!=0) ans+='+';
        ans+='"';
        if(c==1) {ans+=cur; ans+='"';}
        else if(c==2) {ans+=cur; ans+=cur; ans+='"';}
        else {ans+=cur; ans+='"'; ans+='*'; ans+=c;}
        return ans;
    }

    static HashMap<Character,Character> as=new HashMap<>();
    static String maxreduce(String ans)
    {
        int i,j;
        Stack<Character> var=new Stack<>();
        for(i='b';i<='z';i++) var.add((char)i);
        ArrayList<Character> chr=new ArrayList<>();
        for(i='a';i<='z';i++) chr.add((char)i);
        for(i='0';i<='9';i++) chr.add((char)i);
        chr.add('.'); chr.add('#');

        for(char c:chr)
        {
            int el=0;
            for(j=1;j<ans.length()-1;j++)
            if(ans.charAt(j)==c && ans.charAt(j-1)=='"' && ans.charAt(j+1)=='"') el++;
            int red=el*3;
            //v="a"\n->
            red-=2+3+1;
            if(red>0)
            {
                as.put(c,var.peek());
                String reg="";
                reg+='"';
                reg+=c;
                reg+='"';
                String rep=""+var.pop();
                while(ans.contains(reg)) ans=ans.replace(reg,rep);
            }
        }
        return ans;
    }
}
