problem link-https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/palindrome-game-dcf03e89/

#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
#define fast ios_base::sync_with_stdio(0),cin.tie(0),cout.tie(0);
 
map<vector<int>, int> dp;
int cnt[260];
 
int solve(int l, int r, int f, string& s){
    
    if(l > r){
        return 2;
    }
    
    if(cnt[s[l]]+1 > 1 or cnt[s[r]]+1 > 1){
        return f;   
    }
    
    vector<int> v = {l, r, f};
    
    if(dp.count(v) > 0){
        return dp[v];
    }
    
    int next_chance = (f == 0) ? 1 : 0;
    
    cnt[s[l]]++;
    int x = solve(l+1, r, next_chance, s);
    cnt[s[l]]--;
    
    cnt[s[r]]++;
    int y = solve(l, r-1, next_chance, s);
    cnt[s[r]]--;
    
    if(x == f or y == f){
        dp[v] = f;
        return f;
    }
    if(x == 2 or y == 2){
        dp[v] = 2;
        return 2;
    }
    
    dp[v] = next_chance;
    return next_chance;
}
 
int main()
{
    fast
    
    string s;
    cin >> s;
    
    dp.clear();
    memset(cnt, 0, sizeof(cnt));
    
    int win = solve(0, s.length()-1, 0, s);
    if(win == 0){
        cout << "Alice";
    }   
    else if(win == 1){
        cout << "Bob";
    }
    else{
        cout << "Tie";
    }
}
