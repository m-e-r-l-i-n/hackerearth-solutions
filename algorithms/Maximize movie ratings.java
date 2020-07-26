problem link-https://www.hackerearth.com/problem/algorithm/maximize-movie-ratings-1-9f4171c6-8648e75d-33afe308-972d4254-d373dbb9/description/?layout=old

import java.io.*;
import java.util.*;

class TestClass
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bu.readLine());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        int i,x,min=11,sum=0;
        ArrayList<Integer> neg=new ArrayList<>();
        st=new StringTokenizer(bu.readLine());
        for(i=0;i<n;i++)
        {
            x=Integer.parseInt(st.nextToken());
            if(x<0) neg.add(x);
            else
            {
                min=Math.min(min,x);
                sum+=x;
            }
        }

        if(k>=neg.size())
        {
            k-=neg.size();
            for(i=0;i<neg.size();i++)
            {
                sum-=neg.get(i);
                min=Math.min(min,-neg.get(i));
            }
            if(k%2!=0) sum-=2*min;
        }
        else
        {
            Collections.sort(neg);
            for(i=0;i<k;i++)
            sum+=-neg.get(i);
            for(;i<neg.size();i++)
            sum+=neg.get(i);
        }
        System.out.print(sum);
    }
}
