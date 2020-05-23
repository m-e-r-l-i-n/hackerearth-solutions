problem link-https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/debts-429c5441/?layout=old

import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		String s[]=bu.readLine().split(" ");
		int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i;
		long a[]=new long[n+1];
		for(i=0;i<m;i++)
		{
		  s=bu.readLine().split(" ");
		  int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]),x=Integer.parseInt(s[2]);
		  a[l]+=x;
		  a[r]-=x;
		}
		long min=0;
		for(i=1;i<=n;i++)
		if(a[i]>0) min+=a[i];
		System.out.print(min);
    }
}
