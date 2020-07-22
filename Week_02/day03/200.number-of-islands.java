import sun.nio.ch.DirectBuffer;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int[] xdirection={1,-1,0,0};
    private int[] ydirection={0,0,1,-1};

    public int numIslands(char[][] grid) {
        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid,int i,int j){
        grid[i][j]='0';

        for(int k=0;k<xdirection.length;k++){
            int di=i+xdirection[k];
            int dj=j+ydirection[k];

            if(di>=0&&di<grid.length&&dj>=0&&dj<grid[0].length&&grid[di][dj]=='1'){
                dfs(grid, di, dj);
            }
        }
    }
}
// @lc code=end

