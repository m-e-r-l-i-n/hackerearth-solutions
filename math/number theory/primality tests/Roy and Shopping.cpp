problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/roy-and-shopping-20/?layout=old

#include<bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t,i,j,N=1000000,p[N+1];
    memset(p,0,sizeof(p));
    for(i=2;i<=N;i++)
    if(p[i]==0)
    for(j=i;j<=N;j+=i)
    if(p[j]==0) p[j]=i;

    scanf("%d",&t);
    while(t--)
    {
        int n;
        scanf("%d",&n);
        printf("%d\n",n-p[n]);
    }
    return 0;
}
