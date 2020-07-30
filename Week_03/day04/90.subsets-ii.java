/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        generate(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void generate(List<List<Integer>> res,List<Integer> temp,int[] nums,int start){
        res.add(new ArrayList(temp));

        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            generate(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

