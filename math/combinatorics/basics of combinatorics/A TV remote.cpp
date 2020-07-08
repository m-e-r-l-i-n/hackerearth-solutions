problem link-https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/tv-and-remote-183262c5/description/?layout=old

#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;

ll power(ll a,ll b,ll M)
{
    ll res=1;
    while(b)
    {
        if(b%2==1) res=res*a%M;
        b>>=1;
        a=a*a%M;
    }
    return res;
}

int main()
{
    int t,N=100000,i;
    scanf("%d",&t);
    ll f[N],M=1000000007;
    f[0]=1;
    for(i=1;i<=N;i++)
    f[i]=f[i-1]*i%M;

    while(t--)
    {
        int n;
        scanf("%d",&n);
        ll ans=1;
        for(i=2;i<=n;i+=2)
        {
            ll x=(f[n]*power(f[i],M-2,M)%M*power(f[n-i],M-2,M)%M)%M;    //nCr(n,i)
            ll y=(f[i]*power(f[i/2],M-2,M)%M*power(f[i-i/2],M-2,M)%M)%M;   //nCr(i,i/2)
            ans+=(x*y)%M;
            ans%=M;
        }
        printf("%lld\n",ans);
    }
    return 0;
}
