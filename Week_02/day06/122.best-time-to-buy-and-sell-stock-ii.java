/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }

        int max=0,curprice=prices[0];
        for(int i=0;i<prices.length;i++){
            if(curprice<prices[i]){
                max+=prices[i]-curprice;
            }
            curprice=prices[i];
        }

        return max;
    }
}
// @lc code=end

