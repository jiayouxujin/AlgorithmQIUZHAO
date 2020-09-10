/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    int ans=0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid,int x,int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0){
            return 0;
        }

        grid[x][y]=0;
        return 1+dfs(grid,x+1,y)+dfs(grid,x-1,y)+dfs(grid,x,y+1)+dfs(grid,x,y-1);

    }
}
// @lc code=end

