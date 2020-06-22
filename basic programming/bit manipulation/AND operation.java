problem link-https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/and-operation-3-0b1a025c/

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String[] arr = br.readLine().split(" ");
         int N = Integer.parseInt(arr[0]);
         int Q = Integer.parseInt(arr[1]);
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr=0; i_Arr<arr_Arr.length; i_Arr++)
         {
         	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         
         int[] L = new int[Q];
         int[] R = new int[Q];
         int[] Val = new int[Q];
         for(int i_L=0; i_L<Q; i_L++)
         {
            String[] temp = br.readLine().split(" ");
         	L[i_L] = Integer.parseInt(temp[0]);
         	R[i_L] = Integer.parseInt(temp[1]);
         	Val[i_L] = Integer.parseInt(temp[2]);
         	
         }
         
         int[] out_ = AND_Queries(Arr, Val, L, N, Q, R);
         System.out.print(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] AND_Queries(int[] arr, int[] val, int[] l, int n, int q, int[] r){
        // Write your code here
        int i,j,vis[]=new int[n+1],ins[][]=new int[n+1][31],ans[]=new int[n],p2[]=new int[31];
        p2[0]=1;
        for(i=1;i<31;i++) p2[i]=2*p2[i-1];

        for(i=0;i<q;i++)
        {
            vis[l[i]-1]++;
            vis[r[i]]--;
            ArrayList<Integer> s=new ArrayList<>();
            while(val[i]!=0)
            {
                s.add(val[i]&1);
                val[i]>>=1;
            }
            
            for(j=0;j<s.size();j++)
            {
                ins[l[i]-1][j]+=s.get(j);
                ins[r[i]][j]-=s.get(j);
            }
        }
        for(i=1;i<=n;i++)
        {
            vis[i]+=vis[i-1];
            for(j=0;j<31;j++)
            ins[i][j]+=ins[i-1][j];
            
        }

        for(i=0;i<n;i++)
        {
            int v=0;
            for(j=0;j<31;j++)
            if(ins[i][j]==vis[i]) v+=p2[j];
            ans[i]=arr[i]&v;
        }
        return ans;
    }
}
