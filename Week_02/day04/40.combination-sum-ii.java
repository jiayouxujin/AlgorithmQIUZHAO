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
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> temp,int[] candidates,int remains,int start){
        if(remains<0) return ;
        else if(remains==0){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=start;i<candidates.length;i++){
                if(i>start&&candidates[i]==candidates[i-1]) continue;
                temp.add(candidates[i]);
                backtrack(res,temp,candidates,remains-candidates[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
// @lc code=end

