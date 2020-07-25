/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
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
                max=Math.max(max,prices[i]-curprice);
            }else{
                curprice=prices[i];
            }
        }

        return max;
    }
}
// @lc code=end

