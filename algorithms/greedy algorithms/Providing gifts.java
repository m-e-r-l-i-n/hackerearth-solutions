import java.io.*;

class TestClass {
    public static void main(String args[])throws Exception 
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            //sb.append((int)Math.sqrt(n));
            n=(n+1)/2;
            sb.append(n+"\n");
        }
        System.out.print(sb);
    }
}
