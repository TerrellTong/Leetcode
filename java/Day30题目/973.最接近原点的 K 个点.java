/*
	算法思想：
		用小根堆实现，然后直接放入堆中，然后弹出小根堆的根结点
		
		泛型可以用<int[]>表示，记住默认是小根堆！！！即a-b！！！
		如果是要实现大根堆，则是b-a!!

*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //实现一个小根堆
        PriorityQueue<int[]> heap = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return (a[0]*a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
            }
        });
        for(int[] point : points){
            heap.offer(point);
        }

        List<int[]> res = new ArrayList();
        for(int i=1;i<=K;i++){
            res.add(heap.poll());
        }
        return res.toArray(new int[0][]);
    }
}