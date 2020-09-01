/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int x,int y){
        if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]=='1'){
            grid[x][y]='0';
            dfs(grid,x,y+1);
            dfs(grid,x,y-1);
            dfs(grid,x+1,y);
            dfs(grid,x-1,y);
        }else{
            return ;
        }
    }
}
// @lc code=end

