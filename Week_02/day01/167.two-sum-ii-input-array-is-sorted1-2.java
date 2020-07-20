/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        for(int left=0,right=numbers.length;left<right;){
            int sum=numbers[left]+numbers[right];
            if(sum<target){
                left++;
            }else if(sum>target){
                right--;
            }else{
                result[0]=left;
                result[1]=right;
                return result;
            }
        }

        return result;
    }
}
// @lc code=end

