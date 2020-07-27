# 学习笔记

## 刷题日记

目标 300 道 已完成 61 道

[题目是每天新练习的，不包括过遍数的题目，练习时间数据来源于wakatime]

| 时间 | 题目     | 练习时间 |
| ---- | -------- | -------- |
| 7/27 | 1143、72 |          |

## 动态规划

>leetcode 1143
>
>题目大意：最长公共子序列

1. 明确状态 dp-i-j 表示s1前i个字符 s2前j个字符
2. 明确选择 要么字符相等，要么不相等。如果相等 dp-i-j=dp-i-1-j-1+1。不相等的话取最大值
3. base case dp-0-i=0  dp-i-o=0

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();

        int[][] dp=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<=len2;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
```

>leetcode 72
>
>题目大意：通过增删改三个操作使得两个字符串一样

1. 明确状态 dp-i-j 表示word1的前i个字符，word2的前j个字符如果一样，最少的操作步数
2. 明确选择 如果i与j一样，那么就不变。如果不一样，就是增删改三个操作中的一个
3. 明确base case: dp-i-0=i  dp-0-j=j

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            dp[i][0]=i;
        }

        for(int i=0;i<=len2;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }

        return dp[len1][len2];
    }

    public int min(int i,int j,int k){
        return Math.min(i,Math.min(j,k));
    }
}
```



