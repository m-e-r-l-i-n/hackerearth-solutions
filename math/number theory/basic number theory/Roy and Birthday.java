problem link-https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/practice-problems/algorithm/roy-and-birthday/description/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),i,N=1000002;
        long fac[]=new long[N+1],M=1000000007;
        fac[0]=1;
        for(i=1;i<=N;i++)
        fac[i]=(i*fac[i-1])%M;

        while(t-->0)
        {
            String s=bu.readLine();
            int n=s.length(),c[]=new int[26],con=0,vow=0; 
            for(i=0;i<n;i++)
            c[s.charAt(i)-'a']++;
            for(i=0;i<26;i++)
            {
                char ch=(char)(i+'a');
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') vow+=c[i];
                else con+=c[i];
            }
            if(vow>(con+1)) {sb.append("-1\n"); continue;}
            long ans=(fac[con+1]*fac[con])%M;
			ans=(ans*modinv(fac[con+1-vow]))%M;
			for(i=0;i<26;++i) 
			ans=(ans*modinv(fac[c[i]]))%M;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long modinv(long a)
    {
        long res=1,M=1000000007,x=M-2;
        while(x!=0)
        {
            if(x%2==1) res=(res*a)%M;
            x>>=1;
            a=(a*a)%M;
        }
        return res;
    }
}
