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
            int left=i,right=i;
            while(left>=0&&heights[left]>=heights[i]){
                left--;
            }
            while(right<heights.length&&heights[right]>=heights[i]){
                right++;
            }
            int area=(right-left-1)*heights[i];
            max=Math.max(max,area);
        }

        return max;
    }
}
// @lc code=end

