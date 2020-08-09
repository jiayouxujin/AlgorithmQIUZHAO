/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                res+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
// @lc code=end

