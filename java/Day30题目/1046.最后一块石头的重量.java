/*
	算法思想：
		大顶堆即可
*/


class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                //构建一个大顶堆
                return b-a;
            }
        });
        for(int stone:stones){
            queue.add(stone);
        }

        while(!queue.isEmpty() && queue.size() != 1){
            int max1 = queue.poll();
            int max2 = queue.poll();
            if(max1 != max2){
                queue.offer(max1-max2);
            }
        }
        if(queue.size() == 1)
            return queue.poll();
        else
            return 0;
    }
}