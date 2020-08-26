/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<>();
        helper(res,nums,0,new ArrayList<>());
        return new ArrayList(res);
    }

    public void helper(Set<List<Integer>> res,int[] nums,int start,List<Integer> tmp){
        if(tmp.size()>=2){
            res.add(new ArrayList(tmp));
        }
        for(int i=start;i<nums.length;i++){
            if(tmp.size()==0||tmp.get(tmp.size()-1)<=nums[i]){
                tmp.add(nums[i]);
                helper(res,nums,i+1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
// @lc code=end

