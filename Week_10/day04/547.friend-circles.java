/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visit=new boolean[M.length];
        int ans=0;
        for(int i=0;i<M.length;i++){
            if(!visit[i]){
                dfs(M,i,visit);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] M,int k,boolean[] visit){
        visit[k]=true;

        for(int i=0;i<M.length;i++){
            if(M[k][i]==1&&!visit[i]){
                dfs(M,i,visit);
            }
        }
    }
}
// @lc code=end

