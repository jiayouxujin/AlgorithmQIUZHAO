/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            int min=-1;
            for(int coin:coins){
                if(i>=coin&&dp[i-coin]!=-1){
                    int temp=dp[i-coin]+1;
                    min=min<0?temp:(temp<min?temp:min);
                }
            }
            dp[i]=min;
        }

        return dp[amount];
    }
}
// @lc code=end

