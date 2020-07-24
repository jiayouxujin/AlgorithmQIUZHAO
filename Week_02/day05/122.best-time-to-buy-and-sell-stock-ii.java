/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int max=0,preprice=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>preprice){
                max+=prices[i]-preprice;  
            }
            preprice=prices[i];
        }
        return max;
    }
}
// @lc code=end

