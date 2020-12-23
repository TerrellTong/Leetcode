/*
	算法思想：
		堆排序，大根堆
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        for(int num:nums){
            queue.offer(num);
        }
        for(int i=1;i<k;i++)
            queue.poll();
        return queue.poll();
    }
}