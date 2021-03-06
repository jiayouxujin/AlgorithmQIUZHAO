/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int find(int[] parent,int x){
        if(parent[x]==-1){
            return x;
        }
        return find(parent,parent[x]);
    }

    public void union(int[] parent,int x,int y){
        int xset=find(parent,x);
        int yset=find(parent,y);

        if(xset!=yset){
            parent[xset]=yset;
        }
    }
    public int findCircleNum(int[][] M) {
        int[] parent=new int[M.length];
        Arrays.fill(parent,-1);
        for(int i=0;i<M.length;i++){
            for(int j=1;j<M[0].length;j++){
                if(M[i][j]==1&&i!=j){
                    union(parent,i,j);
                }
            }
        }

        int count=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1){
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

