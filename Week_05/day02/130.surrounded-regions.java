/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0) return ;
        if(board.length<3||board[0].length<3) return ;

        int m=board.length,n=board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O') helper(board,i,0);
            if(board[i][n-1]=='O') helper(board,i,n-1);
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O') helper(board,0,i);
            if(board[m-1][i]=='O') helper(board,m-1,i);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='*') board[i][j]='O';
            }
        }
    }

    public void helper(char[][] board,int r,int c){
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!='O') return ;

        board[r][c]='*';
        helper(board,r+1,c);
        helper(board,r-1,c);
        helper(board,r,c+1);
        helper(board,r,c-1);
    }
}
// @lc code=end

