/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children=new TrieNode[26];
    public TrieNode(){}
    TrieNode(char c){
        TrieNode node=new TrieNode();
        node.val=c;
    }
}
class Trie{
    private TrieNode root;
    public Trie(){
        root=new TrieNode();
        root.val='  ';
    }

    public void insert(String word){
        TrieNode ws=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(ws.children[c-'a']==null){
                ws.children[c-'a']=new TrieNode(c);
            }
            ws=ws.children[c-'a'];
        }
        ws.isWord=true;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            
        }
    }
}
// @lc code=end

