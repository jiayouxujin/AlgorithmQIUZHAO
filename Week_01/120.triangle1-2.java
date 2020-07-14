/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length=triangle.size();
        int[] result=new int[length+1];

        for(int i=length-1;i>=0;i--){
            List<Integer> temp=triangle.get(i);

            for(int j=0;j<temp.size();j++){
                result[j]=Math.min(result[j],result[j+1])+triangle.get(i).get(j);
            }
        }

        return result[0];
    }
}
// @lc code=end

