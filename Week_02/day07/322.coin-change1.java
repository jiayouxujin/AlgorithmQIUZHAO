/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        //base case 
        if(amount<0){
            return -1;
        }

        return calDP(coins,new int[amount],amount);
    }

    public int calDP(int[] coins,int[] dp,int rem){
        //base case
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
            if(subAmount>=0&&subAmount<min){
                min=subAmount+1;
            }
        }
        dp[rem-1]=(min==Integer.MAX_VALUE)?-1:min;
        return dp[rem-1];
    }
}
// @lc code=end

