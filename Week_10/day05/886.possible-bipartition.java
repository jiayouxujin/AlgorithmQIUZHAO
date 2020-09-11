/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph=new int[N][N];
        for(int[] cur:dislikes){
            graph[cur[0]-1][cur[1]-1]=1;
            graph[cur[1]-1][cur[0]-1]=1;
        }
        int[] group=new int[N];
        for(int i=0;i<N;i++){
            if(group[i]==0&&!dfs(graph,group,i,1)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph,int[] group,int index,int g){
        group[index]=g;
        for(int i=0;i<graph.length;i++){
            if(graph[index][i]==1){
                if(group[i]==g){
                    return false;
                }
                if(group[i]==0&&!dfs(graph,group,i,-g)){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

