/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0) return new int[0][0];
        Arrays.sort(people,(a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        List<int[]>res =new ArrayList<>();
        for(int[] p:people){
            res.add(p[1],p);
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

