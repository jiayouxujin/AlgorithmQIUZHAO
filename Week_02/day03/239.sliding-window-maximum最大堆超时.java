import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int[] result=new int[len-k+1];
        if(len<=1) return nums;
        
        Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        result[0]=queue.peek();

        for(int i=k;i<len;i++){
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            result[i-k+1]=queue.peek();
        }

        return result;
    }
}
// @lc code=end

