/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        if(amount<0){
            return 0;
        }
        int[][] dp=new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=amount;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
// @lc code=end

