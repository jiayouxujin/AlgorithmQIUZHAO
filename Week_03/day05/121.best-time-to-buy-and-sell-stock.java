/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
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
                res=Math.max(res,prices[i]-curPrice);
            }else{
                curPrice=prices[i];
            }
        }
        return res;
    }
}
// @lc code=end

