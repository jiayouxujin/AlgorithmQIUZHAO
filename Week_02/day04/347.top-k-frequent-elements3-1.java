import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(entry);
        }

        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=queue.poll().getKey();
        }

        return result;
    }
}
// @lc code=end

