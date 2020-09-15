problem link-https://www.hackerearth.com/problem/algorithm/raymond-and-series/description/?layout=old

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll M=1000000007,a,b,c,d;

void fibo(ll n,ll ans[])
{
    if(n==0)
    {
        ans[0]=0;
        ans[1]=1;
        return;
    }
    
    fibo(n/2,ans);
    a=ans[0];             
    b=ans[1];             
    c=2*b-a+M;
    c%=M;
    c=(a*c)%M;
    d=(a*a+b*b)%M;
    if(n%2==0)
    {ans[0]=c; ans[1]=d;}
    else
    {ans[0]=d; ans[1]=(c+d)%M;}
}

int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        ll n;
        scanf("%lld",&n);
        if(n==1) {printf("8\n"); continue;}
        n+=4;
        ll ans[2];
        fibo(n,ans);
        ans[0]*=2;
        ans[0]%=M;
        printf("%lld\n",ans[0]);
    }
    return 0;
}
