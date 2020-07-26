# 学习笔记
## 刷题日记
目标 300 道
已完成 59 道
[题目是每天新练习的，不包括过遍数的题目，练习时间数据来源于wakatime]
|  时间   | 题目  | 练习时间  |
|  ----  | ----  |----   |
| 7/20  | 167 | 47min|
| 7/21  | 144、429、589、590、94 | 2hrs 6mins|
| 7/22  | 239、offer 40、offer 49、347、200 | 2hrs 20 mins |
| 7/23  | 22、226、98、104、111、236、78、90、46、47、39、40、9、125、917 | 4hrs 2 mins |
| 7/24  | 121、122、300、509、62、91 | 2hrs 48 mins |
| 7/25  |  | 1hrs 8 mins |
| 7/26  | 322、416、518 | 1hrs 35 mins |

## 递归
### 递归代码模板
```java
public void recur(level,param1...){
    if(level>MAX_LEVEL){
        return ;
    }

    process(level);

    recur(level+1,p...);

    //清楚本层的环境
    //如果是回溯需要完成此步，或者判断是否影响了全局变量
}
```
### 递归误区
1.  不要人肉递归
2.  重复问题
3.  数学归纳法

## 动态规划
### 思路
1.  递归+记忆化 ->递推
2.  状态定义：opt[n],dp[n],fib[n]
3.  状态转移方程：opt[n]=best_of(opt[n-1],opt[n-2],...)
4.  最优子结构

### 辅助思考状态转移方程
1.  明确base case
2.  明确状态
3.  明确选择
4.  明确dp数组/函数的定义

#### 练题
>leetcode 416
 题目大意：把一个数组分成两个和一样的子集

首先看背包问题的描述
有一个背包可以装M个商品,商品的总重量为N。
这里把需要把这道题转换为背包问题
即一个可以装sum/2重量，商品个数为nums.length的背包，每个商品的重量为num[i]

1.  明确`状态和选择`
    1.  状态是可选择的商品，背包的容量
    2.  选择是 商品要么装进背包，要么不装到背包
2.  明确dp数组的定义 `dp-i-j`表示前i个商品，重量为j，最终的结果是dp-nums.length-sum/2
3.  明确base case，即dp-i....n-0=0

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;

        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=0;j--){
                if(j>=nums[i]){
                    dp[j]=dp[j]|dp[j-nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
```

>leetcode 518
>
>题目大意：换零钱，并且零钱的个数无限

1. 明确状态和选择
   1. 状态就是 可选择的零钱，背包的容量
   2. 选择就是 要么选择该面额的零钱，要么不选择
2. 明确dp数组的定义 dp-i-j表示前i个硬币装成总额为j的方案数，结果就是dp-nums.length-amount
3. 明确选择
   1. 不选择该零钱，那么当前的dp-[i]-[j]=dp-[i-1]-[j]，即当前的方案数等于上一硬币的方案数
   2. 选择该零钱那么当前的方案数 dp-[i]-[j]=dp[i]-[j-coins[i]]，即当前的方案数等于当前硬币面额减去coins的方案数
   3. 这里不同前面的题目，因为要么选择要么不选，但是需要的是最后方案，所以最终结果就是选择零钱和不选择零钱的总和
4. 明确base case
   1. dp[i...n]-[0]=1 因为总额为0表示都不选择

```java
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}
```





