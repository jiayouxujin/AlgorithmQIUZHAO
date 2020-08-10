/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        for(int stone:stones){
            map.put(stone,new HashSet<Integer>());
        }
        map.get(0).add(0);
        for(int i=0;i<stones.length;i++){
            for(int k:map.get(stones[i])){
                for(int step=k-1;step<=k+1;step++){
                    if(step>0&&map.containsKey(stones[i]+step)){
                        map.get(stones[i]+step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length-1]).size()>0;
    }
}
// @lc code=end
