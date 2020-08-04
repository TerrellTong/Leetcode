/*
	算法思想：
		与课程表II类似，也是拓扑排序
		不能直接用for(int[]p : prerequisites)判断，因为存在课程数小于相应的依赖关系
		我们要把入度为0的值放入队列中，每次出队，把入度为0的值放入res中，
		而且度数--后，度数如果为0，则也要加入队列中！
		通过判断res与numberCourse是否相等来判断是否返回true/flase!!
		相当于二刷，但还是不会！！，大致思路知道，但是具体实现还是有问题！！！
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return false;
        //入度表的声明
        int[] inDegrees = new int[numCourses];
        //将每一个二维数组的第一个值放入入度表中
        //因为[1,0]表示想修1，则要修0,1是入度
        for(int[] p : prerequisites)
            inDegrees[p[0]]++;
        //声明一个队列，入度为0的节点入队
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i] == 0)
                queue.offer(i);
        }
        int count = 0;//计数
        int[] res = new int[numCourses];//已学完的课程
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            for(int[] p : prerequisites){
                if(p[1] == cur){
                    inDegrees[p[0]]--;
                    if(inDegrees[p[0]] == 0)
                        queue.offer(p[0]);
                }
            }
        }

        if(count == numCourses) return true;
        return false;
        
        }
}