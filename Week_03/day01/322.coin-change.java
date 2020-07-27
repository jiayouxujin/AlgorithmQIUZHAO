/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp 含义表示总额为amount的最小组合
        if(amount<0){
            return -1;
        }
        int[] dp=new int[amount+1]; 
        dp[0]=0;


        for(int i=1;i<=amount;i++){
            int temp=-1;
            for(int coin:coins){
                if(i>=coin&&dp[i-coin]!=-1){
                    temp=temp<0?dp[i-coin]+1:(temp<dp[i-coin]+1)?temp:dp[i-coin]+1;
                }
            }
            dp[i]=temp;
        }
        return dp[amount];
    }
}
// @lc code=end

