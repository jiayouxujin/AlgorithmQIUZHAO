import java.util.List;
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
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            maxHeap.add(entry);
        }

        int[] result=new int[k];
        for(int i=0;i<result.length;i++){
            Map.Entry<Integer,Integer> entry=maxHeap.poll();
            result[i]=entry.getKey();
        }
        return result;
    }
}
// @lc code=end

