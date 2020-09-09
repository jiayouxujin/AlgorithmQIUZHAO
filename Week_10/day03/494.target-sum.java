/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        int newTarget=(sum+S)/2;
        if(newTarget*2!=sum+S||sum<S){
            return 0;
        }

        int[] dp=new int[newTarget+1];

        dp[0]=1;
        for(int n:nums){
            for(int s=newTarget;s>=n;s--){
                dp[s]+=dp[s-n];
            }
        }
        return dp[newTarget];
    }
}
// @lc code=end

