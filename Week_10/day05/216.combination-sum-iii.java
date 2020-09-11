/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        helper(res,new ArrayList<>(),k,n,1);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> tmp,int k,int n,int start){
        if(tmp.size()>k){
            return ;
        }
        if(n==0&&tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i=start;i<=9;i++){
            if(i<=n){
                tmp.add(i);
                helper(res,tmp,k,n-i,i+1);
                tmp.remove(tmp.size()-1);
            }else{
                break;
            }
        }
    }
}
// @lc code=end

