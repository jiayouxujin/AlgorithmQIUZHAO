/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int[] height=new int[matrix[0].length];

        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }else{
                    height[j]=0;
                }
            }
            ans=Math.max(ans,helper(height));
        }
        return ans;
    }

    public int helper(int[] heights){
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

