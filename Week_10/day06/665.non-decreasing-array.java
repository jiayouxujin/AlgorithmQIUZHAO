/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums==null||nums.length<=1) return true;
        int cnt=1;
        for(int i=1;i<nums.length&&cnt>=0;i++){
            if(nums[i]>=nums[i-1]){
                continue;
            }else{
                int pre=i-2>=0?nums[i-2]:nums[i];
                int next=nums[i];
                nums[i-1]=pre;
                if(pre>next){
                    return false;
                }
                cnt--;
            }
        }
        return cnt>=0;
    }
}
// @lc code=end

