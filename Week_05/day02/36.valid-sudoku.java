/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] row=new HashMap[9];
        HashMap<Integer,Integer>[] column=new HashMap[9];
        HashMap<Integer,Integer>[] boxes=new HashMap[9];

        for(int i=0;i<9;i++){
            row[i]=new HashMap<>();
            column[i]=new HashMap<>();
            boxes[i]=new HashMap<>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char num=board[i][j];
                if(num!='.'){
                    int n=(int)num;
                    int box_index=(i/3)*3+j/3;

                    row[i].put(n,row[i].getOrDefault(n,0)+1);
                    column[j].put(n,column[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);
                    
                    if(row[i].get(n)>1||column[j].get(n)>1||boxes[box_index].get(n)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

