# 学习笔记

## 刷题日记

目标 300 道 已完成 65 道

[题目是每天新练习的，不包括过遍数的题目，练习时间数据来源于wakatime]

| 时间 | 题目     | 练习时间 |
| ---- | -------- | -------- |
| 7/27 | 1143、72、50、169、17、51 | 2 hrs 30 mins |

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

## 分治

### 递归模板

```java
public void recur(level,param1...){
    if(level>MAX_LEVEL){
        return ;
    }
    
    process(param1....)
        
    recur(level+1,p1...);
    
    //reset
}
```

#### 括号生成大法

括号生成题目，要么左括号，要么右括号。这个思想在很多题都可以用到。

1. 子集：要么放，要么不放

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        generate(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void generate(List<List<Integer>> res,List<Integer> temp,int[] nums,int start){
        if(start==nums.length){
            res.add(new ArrayList(temp));
            return ;
        }

        generate(res,temp,nums,start+1);
        temp.add(nums[start]);
        generate(res,temp,nums,start+1);
        //reset
        temp.remove(temp.size()-1);
    }
}
```

2. 背包：要么放，要么不放

### 分支模板

```java
public void divide_problem(problem,param1..){
    if(problem==null){
        print_result;
        return ;
    }
    
    //data prepare
    data=prepare_data(problem);
    subproblems=split_problem(problem,data);
    
    //conquer subproblem
    subresult1=divide_problem(subproblems[0],param1...);
    subresult2=divide_problem(subproblems[1],param1...);
    subresult3=divide_problem(subproblems[2],param1...);
    
    //process result
    result=process_result(subresult11,subresult2...);
}
```



