problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/another-prime-problem/description/?layout=old

#include<bits/stdc++.h>
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int N=1000050,t,a[N+1],i,j,c[N+1];
	memset(a,0,sizeof(a));
	for(i=2;i<=N;i++)
	if(a[i]==0)
	for(j=2*i;j<=N;j+=i) a[j]=1;
	int cp=0;
	a[0]=a[1]=1;
	for(i=N;i>=0;i--)
	{
		if(a[i]==0 && i%11==1) cp=i;
		c[i]=cp;
	}
	
	scanf("%d",&t);
	while(t--)
	{
		int n;
		scanf("%d",&n);
		printf("%d\n",c[n]);
	}
	return 0;
}
