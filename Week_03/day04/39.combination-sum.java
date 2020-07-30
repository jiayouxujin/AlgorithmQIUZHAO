/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        generate(res,new ArrayList<>(),candidates,target,0);
        return res;
    }

    public void generate(List<List<Integer>> res,List<Integer> temp,int[] nums,int rem,int start){
        if(rem<0){
            return ;
        }
        if(rem==0){
            res.add(new ArrayList(temp));
        }
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            generate(res,temp,nums,rem-nums[i],i);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

