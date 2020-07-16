/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];

        for(int i=0;i<graph.length;i++){
            if(color[i]==0&&!validatecolor(graph,color,1,i)){
                return false;
            }
        }

        return true;
    }

    public boolean validatecolor(int[][]graph,int[] colors,int color,int node){
        if(colors[node]!=0){
            return colors[node]==color;
        }

        colors[node]=color;
        for(int next:graph[node]){
            if(!validatecolor(graph, colors, -color,next)){
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

