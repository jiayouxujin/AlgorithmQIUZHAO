/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        int len=heights.length;
        Stack<Integer> stack=new Stack<>();
        int ans=0;
        for(int i=0;i<=len;i++){
            int h=i==len?0:heights[i];
            if(stack.isEmpty()||h>=heights[stack.peek()]){
                stack.push(i);
            }else{
                int sp=stack.pop();
                int area=heights[sp]*(stack.isEmpty()?i:i-1-stack.peek());
                ans=Math.max(area,ans);
                i--;
            }
        }
        return ans;
    }
}
// @lc code=end

