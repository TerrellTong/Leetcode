/*
	算法思想：
		贪心算法！！！不会！！！
		maxTimes为出现次数最多的那个任务出现的次数。maxCount为一共有多少个任务和出现最多的那个任务出现次数一样。



题解：https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for(int i=0;i<tasks.length;i++)
            buckets[tasks[i]-'A']++;
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i=25;i>=1;i--){
            if(buckets[i] == buckets[i-1])
                maxCount++;
            else
                break;
        }
        int res = (maxTimes - 1) * (n+1) +maxCount;
        return Math.max(res,tasks.length);
    }
}