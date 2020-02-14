problem link-https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/joker-and-thieves-53e59f4a/

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            char[][] A = new char[N][N];
            for(int i_A=0; i_A<N; i_A++)
            {
            	String[] arr_A = br.readLine().split(" ");
            	for(int j_A=0; j_A<arr_A.length; j_A++)
            	{
            		A[i_A][j_A] = arr_A[j_A].charAt(0);
            	}
            }

            int out_ = solution(A, K);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int solution(char[][] A, int k){
        // Write your code here
        int s=A.length,i,j,t=0;
        for(i=0;i<s;i++)
        for(j=0;j<s;j++)
        {
        int c=0;
        if(A[i][j]=='P')
        {
            int l=0;
            if((j-k)>0)
            l=j-k;
            for(;l<=j && l>=0;l++)
            if(A[i][l]=='T'){++t;c=1;A[i][l]='x';break;}
            if(c==1) continue;
            {for(l=j+1;l<=j+k && l<s;l++)
            if(A[i][l]=='T'){++t;A[i][l]='x';break;}}
        }}
        return t;
    }
}
