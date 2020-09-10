/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return -1;
        }
        int m=grid.length,n=grid[0].length;
        if(grid[0][0]==1||grid[m-1][n-1]==1){
            return -1;
        }
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int ans=1;
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> cur=queue.poll();
                int x=cur.getKey(),y=cur.getValue();
                if(grid[x][y]==1){
                    continue;
                }
                if(x==m-1&&y==n-1){
                    return ans;
                }

                grid[x][y]=1;
                for(int[] dict:direction){
                    int tmpx=x+dict[0];
                    int tmpy=y+dict[1];
                    if(tmpx<0||tmpx>=m||tmpy<0||tmpy>=n||grid[tmpx][tmpy]==1){
                        continue;
                    }
                    queue.add(new Pair(tmpx,tmpy));
                }
            }
            ans++;
        }
        return -1;
    }
}
// @lc code=end

