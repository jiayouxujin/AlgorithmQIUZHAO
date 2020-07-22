import java.util.LinkedList;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        LinkedList<Integer> dequeue=new LinkedList<>();
        int[] result=new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            while(!dequeue.isEmpty()&&nums[dequeue.peekLast()]<=nums[i]){
                dequeue.pollLast();
            }
            dequeue.addLast(i);
            if(dequeue.peek()<=i-k){
                dequeue.poll();
            }
            if(i+1>=k){
                result[i+1-k]=nums[dequeue.peek()];
            }
        }
        return result;
    }
}
// @lc code=end

