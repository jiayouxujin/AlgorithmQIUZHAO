/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //sum(p)-sum(n)=target
        //sum(p)+sum(n)+sum(p)-sum(n)=sum(nums)+target
        //2*sum(p)=sum(nums)+target

        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if((sum+S)%2!=0||sum<S){
            return 0;
        }
        int newTarget=(sum+S)/2;
        int[][] dp=new int[nums.length+1][newTarget+1];

        //init
        for(int i=0;i<=nums.length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=newTarget;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][newTarget];
    }
}
// @lc code=end

