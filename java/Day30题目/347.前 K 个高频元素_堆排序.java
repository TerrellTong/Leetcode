/*
	算法思想：
		先找到元素出现的次数，我找到了！
		但是后面的利用优先队列建立大顶堆/小顶堆不会！
		用优先队列可以实现自己想要的大顶堆/小顶堆，只需要重写compare方法即可！
	
解题原理：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/

*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //将每个元素出现的次数放入map中
        Map<Integer,Integer> map = new HashMap();
        for(int num:nums){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
        }
        //用优先队列实现一个小顶堆，需要重写compare，使其让它参照计数来进行堆排序
        //使用小根堆，可以避免当大顶堆的值与外面的值想等，这样第二个值就不会进入优先队列了
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return map.get(a)-map.get(b);
            }
        });
        //遍历所有的key,将其进行比较后放到优先队列中
        for(Integer key : map.keySet()){
            if(pq.size() < k)
                pq.offer(key);
                //如果队列满了，就让比优先队列的队头还大的值进来，这样遍历完成后，优先队列只会存储我们想要的前K个大小的值
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.offer(key);
            }
        }
        //取出优先队列中的元素
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.remove();
        }
        return res;
    }
}