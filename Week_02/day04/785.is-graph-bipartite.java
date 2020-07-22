/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors=new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(colors[i]==0&&!isValidateColor(graph,colors,1,i)){
                return false;
            }
        }

        return true;
    }

    public boolean isValidateColor(int[][] graph,int[] colors,int color,int node){
        if(colors[node]!=0){
            return colors[node]==color;
        }

        colors[node]=color;

        for(int next:graph[node]){
            if(!isValidateColor(graph, colors, -color, next)){
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

