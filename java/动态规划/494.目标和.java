/*
	算法思想：
		当int[][] 数组无法满足记忆化的时候，我们可以采用map作为memo
		其key为，用把「状态」转化为字符串作为哈希表的键，这是一个常用的小技巧。
		这题的状态是第i个位置的结果为S的个数和
		
		我按照自己的习惯，写了for，其实这题不需要写for循环！！！因为子问题已经被穷举了出来，就只有+,-两种情况！！！
		
		我自己写的时候，只用了一维数组，所以结果出现了问题！！
	
题解：https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-he-hui-su-suan-fa-dao-di-shui-shi/
*/

class Solution {
    HashMap<String,Integer> memo = new HashMap();
    public int findTargetSumWays(int[] nums, int S) {
        // memo = new int[nums.length][S+1];
        // for(int i=0;i<nums.length;i++)
        //     for(int j=0;j<memo[0].length;j++)
        //         memo[i][j] = -1;
        return find(nums,0,S,0);
    }

    public int find(int[] nums,int pos,int S,int res){
        if(pos == nums.length && S == res){
            return 1;
        }else if (pos == nums.length)
            return 0;

        String key = pos + "," + res;
        if(memo.containsKey(key))
            return memo.get(key);

        //由于是直接到头的，因此可以不用for循环！
        int tmp = find(nums,pos+1,S,res+nums[pos]) + find(nums,pos+1,S,res-nums[pos]);
        memo.put(key,tmp);
        return tmp;
    }   
}