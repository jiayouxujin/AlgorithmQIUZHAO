/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<>();
        helper(res,nums,new ArrayList<>(),0);
        return new ArrayList(res);
    }
    public void helper(HashSet<List<Integer>> res,int[] num,List<Integer> tmp,int start){
        if(tmp.size()>=2){
            res.add(new ArrayList(tmp));
        }
        for(int i=start;i<num.length;i++){
            if(tmp.size()==0||tmp.get(tmp.size()-1)<=num[i]){
                tmp.add(num[i]);
                helper(res,num,tmp,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
// @lc code=end

