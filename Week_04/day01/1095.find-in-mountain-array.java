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
        int mountIndex=findMountainIndex(mountainArr);
        int res=findLeft(mountainArr,0,mountIndex,target);
        if(res==-1){
            return findRight(mountainArr,mountIndex,mountainArr.length()-1,target);
        }else{
            return res;
        }
    }

    public int findMountainIndex(MountainArray mountainArr){
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

    public int findLeft(MountainArray mountainArr,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }

    public int findRight(MountainArray mountainArr,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)<target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

}
// @lc code=end

