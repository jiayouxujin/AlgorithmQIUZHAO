/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        generate(res,new ArrayList<>(),candidates,target,0);
        return res;
    }

    public void generate(List<List<Integer>> res,List<Integer> temp,int[] nums,int rem,int start){
        if(rem<0){
            return ;
        }else if(rem==0){
            res.add(new ArrayList(temp));
        }else{
            for(int i=start;i<nums.length;i++){
                if(i>start&&nums[i]==nums[i-1]) continue;
                temp.add(nums[i]);
                generate(res,temp,nums,rem-nums[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
// @lc code=end

