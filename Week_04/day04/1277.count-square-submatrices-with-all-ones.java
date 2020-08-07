/*
 * @lc app=leetcode id=1277 lang=java
 *
 * [1277] Count Square Submatrices with All Ones
 */

// @lc code=start
class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int[][] dp=new int[matrix.length][matrix[0].length];

        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                }
                ans+=dp[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end

