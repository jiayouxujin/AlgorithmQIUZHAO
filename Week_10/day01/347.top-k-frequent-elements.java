/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> set:map.entrySet()){
           pq.add(set);
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> tmp=pq.poll();
            res[i]=tmp.getKey();
        }
        return res;
    }
}
// @lc code=end

