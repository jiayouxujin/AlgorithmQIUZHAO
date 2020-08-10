/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited=new boolean[M.length];
        int res=0;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(!visited[i]){
                    dfs(M,visited,i);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] M,boolean[] visited,int i){
        for(int j=0;j<M[0].length;j++){
            if(M[i][j]==1&&!visited[j]){
                visited[j]=true;
                dfs(M,visited,j);
            }
        }
    }
}
// @lc code=end

