/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
       int len=graph.length;
       int[] colors=new int[len];

       for(int i=0;i<graph.length;i++){
           if(colors[i]==0&&!isvalidatecolor(graph, colors, 1, i)){
               return false;
           }
       }

       return true;
    }

    public boolean isvalidatecolor(int[][] graph,int[] colors,int color,int node){
        if(colors[node]!=0){
            return colors[node]==color;
        }

        colors[node]=color;

        for(int next:graph[node]){
            if(!isvalidatecolor(graph, colors, -color, next)){
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

