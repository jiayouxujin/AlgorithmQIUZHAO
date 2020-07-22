class Solution {
    public int nthUglyNumber(int n) {
        int[] unglyNumber={2,3,5};
        Queue<Long> queue=new PriorityQueue<>();

        queue.add(1L);
        int count=0;
        while(!queue.isEmpty()){
            long cut=queue.poll();
            count++;
            if(count==n){
                return (int)cut;
            }

            for(int i=0;i<unglyNumber.length;i++){
                if(!queue.contains(cut*unglyNumber[i])){
                    queue.add(cut*unglyNumber[i]);
                }
            }
        }

        return -1;
    }
}