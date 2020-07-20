/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;

        for(int start=0,count=0;count<n;start++){
            int current=start;
            int pre=nums[start];
            do{
                int temp=nums[(current+k)%n];
                nums[(current+k)%n]=pre;
                pre=temp;
                current=(current+k)%n;
                count++;
            }while(start!=current);
        }
    }
}
// @lc code=end

