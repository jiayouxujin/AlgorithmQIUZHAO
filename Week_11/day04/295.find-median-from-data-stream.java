/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> min=new PriorityQueue<>();
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size()<min.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()) return (max.peek()+min.peek())/2.0;
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

