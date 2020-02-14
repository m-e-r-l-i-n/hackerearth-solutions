problem link-https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/what-is-your-mobile-number/

import java.io.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String s=br.readLine();
            if(s.length()==10 && s.charAt(0)!='0' && s.matches("[0-9]+"))
            System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
