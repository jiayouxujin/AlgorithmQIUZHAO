/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    static boolean[][] visit;
    public boolean exist(char[][] board, String word) {
      visit=new boolean[board.length][board[0].length];
      
      for(int i=0;i<board.length;i++){
          for(int j=0;j<board[0].length;j++){
              if(board[i][j]==word.charAt(0)&&helper(board,i,j,0,word)){
                  return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board,int x,int y,int index,String word){
        if(index==word.length()){
            return true;
        }

        if(x<0||x>=board.length||y<0||y>=board[0].length||word.charAt(index)!=board[x][y]||visit[x][y]){
            return false;
        }

        visit[x][y]=true;
        if(helper(board,x+1,y,index+1,word)||helper(board,x-1,y,index+1,word)||helper(board,x,y-1,index+1,word)||helper(board,x,y+1,index+1,word)){
            return true;
        }
        visit[x][y]=false;
        return false;
    }
}
// @lc code=end

