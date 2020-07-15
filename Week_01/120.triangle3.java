/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n+1];

        for(int i=n-1;i>=0;i--){
            List<Integer> temp=triangle.get(i);
            for(int j=0;j<temp.size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+temp.get(j);
            }
        }
        return dp[0];
    }
}
// @lc code=end

