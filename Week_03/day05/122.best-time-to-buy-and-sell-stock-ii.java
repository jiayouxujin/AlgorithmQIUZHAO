/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int curPrice=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>curPrice){
                res+=prices[i]-curPrice;
            }
            curPrice=prices[i];
        }
        return res;
    }
}
// @lc code=end

