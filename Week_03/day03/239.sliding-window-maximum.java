/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        int n=nums.length;
        int[] res=new int[n-k+1];
        LinkedList<Integer> dqueue=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!dqueue.isEmpty()&&nums[dqueue.peekLast()]<nums[i]){
                dqueue.pollLast();
            }

            dqueue.addLast(i);
            if(dqueue.peek()<=i-k){
                dqueue.poll();
            }

            if(i+1>=k){
                res[i+1-k]=nums[dqueue.peek()];
            }
        }

        return res;
    }
}
// @lc code=end

