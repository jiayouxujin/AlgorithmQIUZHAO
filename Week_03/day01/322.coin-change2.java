/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        //状态：可选择的硬币，背包剩余的容量
        //选择要么选，要么不选，如果选的话dp[amount]=dp[amount-coins]
        //base case:amount<0 return -1,amount=0 return 0

        if(amount<0){
            return -1;
        }
        return calDP(coins,new int[amount],amount);
    }

    public int calDP(int[] coins,int[] dp,int rem){
        if(rem<0){
            return -1;
        }
        if(rem==0){
            return 0;
        }
        if(dp[rem-1]!=0){
            return dp[rem-1];
        }

        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int subAmount=calDP(coins,dp,rem-coin);
            if(subAmount>=0&&subAmount+1<min){
                min=subAmount+1;
            }
        }

        dp[rem-1]=min==Integer.MAX_VALUE?-1:min;
        return dp[rem-1];
    }
}
// @lc code=end

