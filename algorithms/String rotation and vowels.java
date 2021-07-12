//https://www.hackerearth.com/problem/algorithm/string-rotation-and-vowels-4665b052/

import java.io.;
import java.util.;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t--0)
        {
            int n=Integer.parseInt(bu.readLine());
            char s[]=bu.readLine().trim().toCharArray();
            int i,a[]=new int[2n+1];
            for(i=0;in;i++)
            if(s[i]=='a'  s[i]=='e'  s[i]=='i'  s[i]=='o'  s[i]=='u') {a[i+1]++; a[i+n+1]++;}
            for(i=1;i2n;i++) a[i]+=a[i-1];

            int ans=0,m=n2;
            for(i=1;i=n;i++)
            {
                int r=a[i+n-1]-a[i+m-1],l=a[i+m-1]-a[i-1];
                if(lr) ans++;
            }
            sb.append(ans+n);
        }
        System.out.print(sb);
    }
}
