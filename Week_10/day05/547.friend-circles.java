/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        if(M==null||M.length==0){
            return 0;
        }
        int ans=0;
        boolean[] visit=new boolean[M.length];
        for(int i=0;i<M.length;i++){
            if(!visit[i]){
                dfs(M,i,visit);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] M,int index,boolean[] visit){
        visit[index]=true;
        for(int i=0;i<M.length;i++){
            if(M[index][i]==1&&!visit[i]){
                dfs(M,i,visit);
            }
        }
    }
}
// @lc code=end

