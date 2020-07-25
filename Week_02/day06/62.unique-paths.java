/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path=new int[n][m];

        for(int i=0;i<n;i++){
            path[i][0]=1;
        }

        for(int j=0;j<m;j++){
            path[0][j]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }

        return path[n-1][m-1];
    }
}
// @lc code=end

