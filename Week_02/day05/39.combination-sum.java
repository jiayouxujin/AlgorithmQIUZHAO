/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> temp,int[] nums,int remain,int start){
        if(remain<0) return ;
        else if(remain==0){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=start;i<nums.length;i++){
                temp.add(nums[i]);
                backtrack(res,temp,nums,remain-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
// @lc code=end

