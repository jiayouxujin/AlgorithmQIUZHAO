/*
 * @lc app=leetcode id=1095 lang=java
 *
 * [1095] Find in Mountain Array
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int maxIndex=getMountainMax(mountainArr);
        int res=getLeftAns(target,mountainArr,0,maxIndex);

        if(res==-1){
            return getRightAns(target,mountainArr,maxIndex,mountainArr.length()-1);
        }else{
            return res;
        }
    }

    public int getLeftAns(int target,MountainArray mountainArr,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public int getRightAns(int target,MountainArray mountainArr,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)>target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public int getMountainMax(MountainArray mountainArr){
        int left=0,right=mountainArr.length()-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
// @lc code=end

