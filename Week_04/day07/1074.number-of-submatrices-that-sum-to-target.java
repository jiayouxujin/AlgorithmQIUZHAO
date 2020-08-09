/*
 * @lc app=leetcode id=1074 lang=java
 *
 * [1074] Number of Submatrices That Sum to Target
 */

// @lc code=start
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res=0,m=matrix.length,n=matrix[0].length;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                map.clear();
                map.put(0,1);
                int cur=0;
                for(int k=0;k<m;k++){
                    cur+=matrix[k][j]-(i>0?matrix[k][i-1]:0);
                    res+=map.getOrDefault(cur-target,0);
                    map.put(cur,map.getOrDefault(cur,0)+1);
                }
            }
        }
        return res;
    }
}
// @lc code=end

