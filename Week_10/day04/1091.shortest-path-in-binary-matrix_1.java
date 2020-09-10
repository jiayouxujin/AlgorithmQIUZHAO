/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid.length==0||grid[0][0]==1||grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }

        int[][] dict={{1,-1},{1,1},{1,0},{0,1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        int ans=1;
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
            Pair<Integer,Integer> cur=queue.poll();

            if(grid[cur.getKey()][cur.getValue()]==1){
                continue;
            }
            if(cur.getKey()==grid.length-1&&cur.getValue()==grid[0].length-1){
                return ans;
            }

            grid[cur.getKey()][cur.getValue()]=1;
            for(int k=0;k<dict.length;k++){
                int tmpx=cur.getKey()+dict[k][0];
                int tmpy=cur.getValue()+dict[k][1];
                if(tmpx>=0&&tmpx<grid.length&&tmpy>=0&&tmpy<grid[0].length&&grid[tmpx][tmpy]==0){
                    queue.add(new Pair(tmpx,tmpy));
                }
            }
            }
            ans++;
        }
        return -1;
    }
}
// @lc code=end

