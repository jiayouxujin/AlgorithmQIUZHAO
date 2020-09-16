/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int n:nums){
            if(!map.containsKey(n)){
                int left=map.containsKey(n-1)?map.get(n-1):0;
                int right=map.containsKey(n+1)?map.get(n+1):0;
                int sum=left+right+1;

                map.put(n,sum);
                res=Math.max(res,sum);

                map.put(n-left,sum);
                map.put(n+right,sum);
            }
        }
        return res;
    }
}
// @lc code=end

