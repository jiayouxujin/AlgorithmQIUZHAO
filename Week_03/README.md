# 学习笔记

## 刷题日记

目标 300 道 已完成 70 道

[题目是每天新练习的，不包括过遍数的题目，练习时间数据来源于wakatime]

| 时间 | 题目     | 练习时间 |
| ---- | -------- | -------- |
| 7/27 | 1143、72、50、169、17、51 | 2 hrs 30 mins |
| 7/28 | 887、198、102 | 2 hrs 14 mins |
| 7/29 | 213、337 | 1 hrs 6 mins |
| 7/30 |  | 1 hrs 10 mins |

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

>leetcode 887
>
>题目大意：有N层楼，给你K个鸡蛋，问你最坏情况下，最少要花多少次机会找出楼层F
>
>其中楼层F表示从大于等于F的楼层扔鸡蛋，鸡蛋都不会碎。从低于F扔鸡蛋会碎。

【最坏情况】

举个例子例如7层，从第一层开始扔，扔到最后一层都没有碎，那么此时就是最坏的情况。

【最少次数】

还是以上面的例子为例，可以使用二分法来扔鸡蛋，这样就能够把次数减少到logN

1. 明确状态 表示剩下K个鸡蛋，楼层的范围为N
2. 明确选择 从哪一层开始扔鸡蛋
3. 明确dp，dp-i-j 表示剩下i个鸡蛋楼层范围为j
4. base case: 如果楼层小于等于1，那么次数就是N。如果鸡蛋只有一个那么只能使用线性的方法进行尝试。

```java
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp=new int[K+1][N+1];
        return helper(dp,K,N);
    }
    public int helper(int[][] dp,int k,int n){
        if(n<=1){
            return n;
        }
        if(k==1){
            return n;
        }
        if(dp[k][n]>0){
            return dp[k][n];
        }

        int low=1,hight=n,result=n;
        while(low<hight){
            int mid=(low+hight)/2;
            int left=helper(dp,k-1,mid-1);
            int right=helper(dp,k,n-mid);
            result=Math.min(result,Math.max(left,right)+1);
            if(left==right){
                break;
            }else if(left<right){
                low=mid+1;
            }else{
                hight=mid;
            }
        }
        dp[k][n]=result;
        return dp[k][n];
    }
}
```

>leetcode 198
>
>题目大意：抢劫，一排房子，不能进入连续的房子进行抢劫。

1. 明确状态：当前的房子
2. 明确选择：抢或者不抢
3. 明确dp：dp-i 表示第i个房子
4. 状态转移：如果第i家抢，那么dp-i=nums[i]+dp-i+2，如果不抢就是dp-i=dp-i+1

```java
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];

        for(int i=n-1;i>=0;i--){
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }

        return dp[0];
    }
}
```

>leetcode 213
>
>题目大意：与上一题基本相同，不同的地方就是房子是环形的，也就是说首尾是相连的，那么就无法同时抢首尾

```java
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(solve(nums,0,nums.length-2),solve(nums,1,nums.length-1));
    }

    public int solve(int[] nums,int start,int end){
        int dp_i=0,dp_i1=0,dp_i2=0;
        for(int i=end;i>=start;i--){
            dp_i=Math.max(dp_i1,dp_i2+nums[i]);
            dp_i2=dp_i1;
            dp_i1=dp_i;
        }
        return dp_i;
    }
}
```

>leetcode 337
>
>题目大意：还是抢劫，不过这回房子是二叉树的形式

还是按照我们先前讨论的思路就是抢或者不抢，如果抢的下一个就不抢，如果不抢的话下一个可以抢可以不抢具体要看哪种方案比较大。

```java
class Solution {
    Map<TreeNode,Integer> map=new HashMap<>();

    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }

        int rob_it=root.val+(root.left==null?0:rob(root.left.left)+rob(root.left.right))+(root.right==null?0:rob(root.right.left)+rob(root.right.right));
        int not_rob=rob(root.left)+rob(root.right);

        int res=Math.max(rob_it,not_rob);
        map.put(root,res);
        return res;
    }
}
```

```java
class Solution {
    public int rob(TreeNode root) {
        int[] res=dp(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dp(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left=dp(root.left);
        int[] right=dp(root.right);

        int rob_it=root.val+left[0]+right[0];
        int no_rob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{no_rob,rob_it};
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



