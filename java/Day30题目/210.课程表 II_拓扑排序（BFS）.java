/*
	算法思想：
		拓扑排序的实现，BFS
*/
 

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return new int[0];
        //声明入度表,通过遍历给每个结点的入度值++
        int[] inDegress = new int[numCourses];
        for(int[] p : prerequisites){
            inDegress[p[0]]++;
        }
        //声明一个队列，入度为0的结点入队
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<inDegress.length;i++){
            if(inDegress[i] == 0)
                queue.offer(i);
        }
        int count = 0;//记录可以学完的课程数量
        int[] res = new int[numCourses]; //已学完的课程
        //根据提供的先修课列表，删除入度为0的结点
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr; //将学完的课程加入到res数组中
            for(int[] p : prerequisites){
                //如果某个课程的先修课程是这门课程，那么p[0]的入度--
                if(p[1] == curr){
                    inDegress[p[0]]--;
                    //如果--后，p[0]的入度变为了0，就加入到queue中
                    if(inDegress[p[0]] == 0)
                        queue.offer(p[0]);
                }
            }
        }
        if(count == numCourses) return res;
        //随便返回一个值
        return new int[0];
    }
}











