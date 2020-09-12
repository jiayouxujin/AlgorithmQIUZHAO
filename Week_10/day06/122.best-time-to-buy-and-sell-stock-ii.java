/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                ans+=(prices[i]-prices[i-1]);
            }
        }
        return ans;
    }
}
// @lc code=end

