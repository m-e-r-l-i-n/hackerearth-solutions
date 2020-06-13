problem link-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/ultra-prime/description/?layout=old

#include<bits/stdc++.h>
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int i,j,N=1000001,pr[N+1]={0},cnt=0,c[N+1],t;
	for(i=2;i<=N;i++)
	if(pr[i]==0)
	for(j=2*i;j<=N;j+=i)
	pr[j]=1;

	c[0]=c[1]=0;
	for(i=2;i<=N;i++)
	{
		c[i]=cnt;
		if(pr[i]==0)
		{
			int sum=0,d=i;
			while(d!=0)
			{sum+=d%10; d/=10;}
			if(pr[sum]==0) cnt++;
		}
	}
	
	scanf("%d",&t);
	while(t--)
	{
		int l,r;
		scanf("%d%d",&l,&r);
		printf("%d\n",c[r+1]-c[l]);
	}
}
