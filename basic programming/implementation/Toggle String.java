import java.io.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        char s[]=bu.readLine().trim().toCharArray();
        for(char c:s)
        {
            if(c>='a' && c<='z') c-=32;
            else c+=32;
            sb.append(c);
        }
        System.out.print(sb);
    }
}
