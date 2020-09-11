/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] group=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(group[i]==0&&!dfs(graph,group,i,1)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int[] group,int index,int g){
        group[index]=g;
        for(int i=0;i<graph[index].length;i++){
            int cur=graph[index][i];
            if(group[cur]==g){
                return false;
            }
            if(group[cur]==0&&!dfs(graph,group,cur,-g)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

