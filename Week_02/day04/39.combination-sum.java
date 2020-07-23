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
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> temp,in[] candidates,int remains,int start){
        if(remains<0) return ;
        else if(remains==0){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=start;i<candidates.length;i++){
                temp.add(candidates[i]);
                backtrack(res,temp,candidates,remains-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
// @lc code=end

