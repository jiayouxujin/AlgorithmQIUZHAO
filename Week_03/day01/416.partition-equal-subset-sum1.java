/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        //状态是 可选择的数字 剩余的总数
        //选择 该数字要么选择要么不选择 选择话就是等于前面dp[i-1][sum-nums[i]],不选择等于 dp[i-1][sum]
        // dp[i][j]  表示前i个数字组成j的总数 
        // base case dp[i][0]=true
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        int n=nums.length;
        boolean[][] dp=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
// @lc code=end

