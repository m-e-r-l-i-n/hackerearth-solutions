problem link-https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/special-shop-69904c91/

#include <bits/stdc++.h>
using namespace std;
#define ll unsigned long
 
ll n,a,b;
 
ll mn(ll i)
{
	return 1LL*a*i*i+1LL*b*(n-i)*(n-i);
}
 
int main()
{

	int q; 
	cin >> q;
	while (q--)
	{
		cin>>n>>a>>b;
		ll x=mn(floor((b*n)/(a+b))), y=mn(floor(b*n/(a+b))+1);
		cout<<min(x,y) <<endl;
	}
 
	return 0;
}
