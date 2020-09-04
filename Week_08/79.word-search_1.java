/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0)
            return false;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visit=new boolean[board.length][board[0].length];
                if(helper(board,i,j,word,new StringBuilder(),visit)){
                    return true;
                }
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board,int x,int y,String word,StringBuilder sb,boolean[][] visit){
        if(sb.length()>word.length()||(sb.length()>=1&&sb.toString().charAt(sb.length()-1)!=word.charAt(sb.length()-1))){
            return false;
        }
        if(sb.length()==word.length()&&sb.toString().equals(word)){
            return true;
        }

        if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&visit[x][y]==false){
            sb.append(board[x][y]);
            visit[x][y]=true;
            if(helper(board,x+1,y,word,sb,visit)||helper(board,x-1,y,word,sb,visit)||helper(board,x,y-1,word,sb,visit)||helper(board,x,y+1,word,sb,visit)){
                return true;
            }
            sb.setLength(sb.length()-1);
            visit[x][y]=false;
        }
        return false;
    }
}
// @lc code=end

