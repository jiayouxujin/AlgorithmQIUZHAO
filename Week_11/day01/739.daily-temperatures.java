/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0) return new int[0];
        int[] dp=new int[T.length];
        dp[T.length-1]=0;
        for(int i=T.length-2;i>=0;i--){
            for(int j=i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    dp[i]=j-i;
                    break;
                }
            }
        }
        return dp;
    }
}
// @lc code=end

