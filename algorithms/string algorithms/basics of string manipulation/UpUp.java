problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/upup/?layout=old

import java.io.*;
class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        char s[]=bu.readLine().toCharArray();
        if(s[0]>='a' && s[0]<='z') s[0]=(char)(s[0]-32);
        sb.append(s[0]);
        for(int i=1;i<s.length;i++)
        if(s[i-1]==' ')
        {
            if(s[i]>='a' && s[i]<='z')
                sb.append((char)(s[i]-32));
            else sb.append(s[i]);
        }
        else sb.append(s[i]);
        System.out.print(sb);
    }
}
