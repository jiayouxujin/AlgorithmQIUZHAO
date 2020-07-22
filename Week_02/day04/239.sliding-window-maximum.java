import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> dequeue=new LinkedList<>();
        int[] result=new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            while(!dequeue.isEmpty()&&nums[dequeue.peekLast()]<=nums[i]){
                dequeue.pollLast();
            }
            dequeue.addLast(i);
            if(dequeue.peekFirst()<=i-k){
                dequeue.poll();
            }
            if(i+1>=k){
                result[i-k+1]=nums[dequeue.peek()];
            }
        }

        return result;
    }
}
// @lc code=end

