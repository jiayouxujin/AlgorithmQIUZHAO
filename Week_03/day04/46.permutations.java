/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        genereate(res,new LinkedHashMap<>(),nums);
        return res;
    }

    public void genereate(List<List<Integer>> res,LinkedHashMap<Integer,Integer> temp,int[] nums){
        if(temp.values().size()==nums.length){
            res.add(new ArrayList(temp.values()));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(temp.containsKey(nums[i])) continue;
            temp.put(nums[i],nums[i]);
            genereate(res,temp,nums);
            temp.remove(nums[i]);
        }
    }
}
// @lc code=end

