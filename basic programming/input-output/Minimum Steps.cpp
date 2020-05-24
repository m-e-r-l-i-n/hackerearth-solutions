problem link-https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/step-conversion/description/?layout=old

#include<bits/stdc++.h>
using namespace std;

int steps(int k,int m,int n)
{
	if(k>=m) return (k-m)/2+(k-m)%2;
	if(m%n==0) return 1+steps(k,m/n,n);
	int x=(m/n+1)*n;
	return (x-m)/2+(x-m)%2+steps(k,x,n);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int k,m,n;
		scanf("%d%d%d",&k,&m,&n);
		printf("%d\n",steps(k,m,n));
	}
	return 0;
}
