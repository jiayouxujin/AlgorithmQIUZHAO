/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int max=0;
        for(int i=0;i<heights.length;i++){
            int minHeight=heights[i];
            for(int j=i;j<heights.length;j++){
                minHeight=Math.min(minHeight,heights[j]);
                int area=(j-i+1)*minHeight;
                max=Math.max(max,area);
            }
        }

        return max;
    }
}
// @lc code=end

