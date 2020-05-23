problem link-https://www.hackerearth.com/problem/algorithm/or-b3c038d1/?layout=old

import java.io.*;
 
class TestClass 
{
    public static void main(String args[] ) throws Exception {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        long a=Long.parseLong(bu.readLine()),b=Long.parseLong(bu.readLine());
        if(a>b) a=a^b^(b=a);
        int msb=(int)(Math.log(b)/Math.log(2)),i;
        for(i=msb;i>=0;i--)
        if(((b>>i)&1l)!=((a>>i)&1l)) break;
        if(i==-1) {System.out.print("1"); return;}  //l==r
 
        long ans=(b-a+1),r=0,l=0; msb=i;  //all numbers in the range are counted
        for(i=msb;i>=0;i--) //we need only that range between the 2 numbers that can create a difference
        {
            if(((b>>i)&1l)==1) r+=(long)Math.pow(2,i);
            if(((a>>i)&1l)==1) l+=(long)Math.pow(2,i);
        }
        int msr=(int)(Math.log(r)/Math.log(2));
        long top=(long)Math.pow(2,msr+1),bottom=(long)Math.pow(2,msr),diff=r-bottom;    
        long curr=ans;
        /*top=smallest power of 2 larger than r 
        bottom=largest power of 2 smaller than r
        diff=difference between r and bottom
        we need curr for abrupt cases(only 1 such test case given)*/
        
        diff=(long)Math.pow(2,(int)(Math.log(diff)/Math.log(2))+1)-1-diff;
        if(diff<0) diff=0;
        ans+=diff;  
        
        /*see the case of 11. 9 10 and 11, the max value that can be created by them is 13
        so we can say diff=11-8=3. Largest power of 2 bigger than diff=4. 4-1=3 So we will add 0 here(because there will be no numbers such that the or will be >11)
        However, in case of l=100 r=200, the diff=88. 2^n-1=127. So new diff=127-88=39. So we will add 39 to answer. The new r will be 239.*/
        
        long lval=top-(r+diff)-1; //lval=next higest power of 2-1-r(current r)
        ans+=Math.min(lval,bottom-l);
        if(ans>2*curr) ans=curr;
        System.out.print(ans);
    }
}
