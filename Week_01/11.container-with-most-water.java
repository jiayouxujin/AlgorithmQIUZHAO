/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max=0;

        for(int i=0,j=height.length-1;i<j;){
            int minHeight=height[i]<height[j]?height[i++]:height[j--];
            int area=minHeight*(j-i+1);
            max=Math.max(max,area);
        }
        return max;
    }
}
// @lc code=end

