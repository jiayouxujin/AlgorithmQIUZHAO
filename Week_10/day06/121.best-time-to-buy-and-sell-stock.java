/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        if(prices==null||prices.length==0) return ans;
        int curprice=prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]>curprice){
                ans=Math.max(ans,prices[i]-curprice);
            }
            curprice=Math.min(curprice,prices[i]);
        }
        return ans;
    }
}
// @lc code=end

