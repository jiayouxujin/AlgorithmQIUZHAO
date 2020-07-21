/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] res=new int[2];
        for(int left=0,right=numbers.length-1;left<right;){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

