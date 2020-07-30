/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        generate(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }

    public void generate(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] visited){
        if(temp.size()==nums.length){
            res.add(new ArrayList(temp));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]||i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
            temp.add(nums[i]);
            visited[i]=true;
            generate(res,temp,nums,visited);
            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}
// @lc code=end

