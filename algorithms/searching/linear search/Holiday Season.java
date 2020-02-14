problem link-https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/holiday-season-ab957deb/description/

import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,j,k,l; long c=0;
        String s=bu.readLine();
        
        if(n<4) {System.out.print(0); return;}
        int a[]=new int[26];
		for(i=0;i<n;i++)    //get b from here
		{
			long count=0;
			for(j=i+1;j<n;j++) //get d from here
			{
				if(s.charAt(i)==s.charAt(j))    c+=count;
				count+=a[s.charAt(j)-'a'];  //here we are counting common characters that can resemble a and c
			}
			a[s.charAt(i)-'a']++;
		}
        System.out.print(c);
    }
}
