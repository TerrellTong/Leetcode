/*
	算法思想：
		单调栈，维护一个单调递减栈！ 我考虑的是单调递增栈！！，这是我的问题！  
		知道单调栈，但是我只知道单调递增栈，如果用单调递增栈，栈顶的最大值的下一天最高温度就解决不了了
	
	8个月前做过，还是不会！！！
		
	题解：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/  思路2
	
*/


class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[T.length];
        for(int i=0;i<T.length;i++){
            int curTemp = T[i];
            while(!stack.isEmpty() && curTemp > T[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            //存储温度i的下标
            stack.push(i);
        }
        return ans;
    }
}