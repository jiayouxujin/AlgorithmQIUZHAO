/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int[] dx={1,-1,0,0};
    private int[] dy={0,0,1,-1};

    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int x,int y){
        grid[x][y]='.';

        for(int i=0;i<4;i++){
            int ddx=dx[i]+x;
            int ddy=dy[i]+y;

            if(ddx>=0&&ddx<grid.length&&ddy>=0&&ddy<grid[0].length&&grid[ddx][ddy]=='1'){
                dfs(grid,ddx,ddy);
            }
        }
    }
}
// @lc code=end

