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

        dfs(res,board,0);
        return res;
    }

    public void dfs(List<List<String>> res,char[][] board,int colIndex){
        if(colIndex==board.length){
            res.add(constructor(board));
            return ;
        }

        for(int i=0;i<board.length;i++){
            if(isValidate(board,i,colIndex)){
                board[i][colIndex]='Q';
                dfs(res,board,colIndex+1);
                board[i][colIndex]='.';
            }
        }
    }

    public boolean isValidate(char[][] board,int x,int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='Q'&&(x+y==i+j||x+j==y+i||x==i)){
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> constructor(char[][] board){
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
// @lc code=end

