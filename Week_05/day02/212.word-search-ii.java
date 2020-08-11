/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        TrieNode p=buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,p,res);
            }
        }
        return res;
    }

    public TrieNode buildTrie(String[] word){
        TrieNode root=new TrieNode();
        for(String s:word){
            TrieNode p=root;
            for(char c:s.toCharArray()){
                if(p.children[c-'a']==null) p.children[c-'a']=new TrieNode();
                p=p.children[c-'a'];
            }
            p.word=s;
        }
        return root;
    }

    public void dfs(char[][] board,int i,int j,TrieNode p,List<String> res){
        char c=board[i][j];
        if(c=='#'||p.children[c-'a']==null) return ;
        p=p.children[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }

        board[i][j]='#';
        if(i>0) dfs(board,i-1,j,p,res);
        if(j>0) dfs(board,i,j-1,p,res);
        if(i<board.length-1) dfs(board,i+1,j,p,res);
        if(j<board[0].length-1) dfs(board,i,j+1,p,res);
        board[i][j]=c;
    }
}

class TrieNode{
    TrieNode[] children=new TrieNode[26];
    String word;
}
// @lc code=end

