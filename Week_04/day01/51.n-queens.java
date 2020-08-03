/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        generate(res,board,0);
        return res;
    }

    public void generate(List<List<String>> res,char[][] board,int colIndex){
        if(colIndex==board.length){
            res.add(constructor(board));
            return ;
        }

        for(int i=0;i<board.length;i++){
            if(isValidate(board,i,colIndex)){
                board[i][colIndex]='Q';
                generate(res,board,colIndex+1);
                board[i][colIndex]='.';
            }
        }
    }

    public boolean isValidate(char[][] board,int x,int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='Q'&&(x+j==i+y||x+y==i+j||x==i)){
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> constructor(char[][] board){
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}
// @lc code=end

