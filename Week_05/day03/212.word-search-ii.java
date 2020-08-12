/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode p=buildTrie(words);
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,p,res);
            }
        }
        return res;
    }
    public void dfs(char[][] board,int i,int j,TrieNode p,List<String> res){
        if(i<0||j<0||i>=board.length||j>=board[0].length) return ;
        
        char c=board[i][j];
        if(c=='#'||p.children[c-'a']==null) return ;

        p=p.children[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }

        board[i][j]='#';
        dfs(board,i+1,j,p,res);
        dfs(board,i-1,j,p,res);
        dfs(board,i,j+1,p,res);
        dfs(board,i,j-1,p,res);
        board[i][j]=c;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode ws=root;
            for(char c:word.toCharArray()){
                if(ws.children[c-'a']==null){
                    ws.children[c-'a']=new TrieNode();
                }
                ws=ws.children[c-'a'];
            }
            ws.word=word;
        }
        return root;
    }
}

class TrieNode{
    public TrieNode[] children=new TrieNode[26];
    public String word;
}
// @lc code=end

