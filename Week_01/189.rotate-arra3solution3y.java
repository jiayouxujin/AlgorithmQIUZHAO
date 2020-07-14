/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;

        int count=0,current,temp,previous;
        for(int start=0;count<nums.length;start++){
            current=start;
            temp=nums[start];
            do{
                previous=temp;
                temp=nums[(current+k)%nums.length];
                nums[(current+k)%nums.length]=previous;
                current=(current+k)%nums.length;
                count++;
            }while(current!=start);
        }
    }
}
// @lc code=end

