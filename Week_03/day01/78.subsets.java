/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        generate(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void generate(List<List<Integer>> res,List<Integer> temp,int[] nums,int start){
        if(start==nums.length){
            res.add(new ArrayList(temp));
            return ;
        }

        generate(res,temp,nums,start+1);
        temp.add(nums[start]);
        generate(res,temp,nums,start+1);
        //reset
        temp.remove(temp.size()-1);
    }
}
// @lc code=end

