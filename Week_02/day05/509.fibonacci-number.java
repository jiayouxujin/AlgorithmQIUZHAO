/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if(N<=1) return N;
        int[] dp=new int[N+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[N];
    }
}
// @lc code=end

