# 学习笔记

## 刷题日记

目标 300 道 已完成 106 道

[题目是每天新练习的，不包括过遍数的题目，练习时间数据来源于wakatime]

| 时间 | 题目 | 练习时间      |
| :--- | :--- | :------------ |
| 8/10 |   547、130、208   | 1 hrs 41 mins |
| 8/11 | 212、127、433、36 | 1 hrs 48 mins |
| 8/12 | 37、191、231 | 1 hrs 19 mins  |

## 字典树

```java
class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children=new TrieNode[26];
    public TrieNode(){}
    public TrieNode(char c){
        TrieNode node=new TrieNode();
        node.val=c;
    }
}
class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
        root.val=' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(ws.children[c-'a']==null) return false;
            ws=ws.children[c-'a'];
        }
        return ws.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(ws.children[c-'a']==null) return false;
            ws=ws.children[c-'a'];
        }
        return true;
    }
}
```

## 高级搜索

### 双向BFS

```java
public void deBFS(begin,end,group){
	Set<String> beginSet=new HashSet<>();
    Set<String> endSet=new HashSet<>();
    Set<String> groupSet=new HashSet<>(group);
    Set<String> visited=new HashSet<>();
    	
   	beginSet.add(begin);
    endSet.add(end);
    //提前判断
    if(!groupSet.contains(end)){
        return ;
    }
    
    //开始BFS
    while(!beginSet.contains(begin)&&!endSet.contains(end)){
        //swap
        if(beginSet.size()>endSet.size()){
            //swap 让beginSet的长度比较小点
        }
        
        for(String str:beginSet){
            //process
        }
    }
}
```

