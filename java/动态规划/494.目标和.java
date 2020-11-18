/*
	算法思想：
		从一个点开始，然后依次走到下一个结点，判断是否能回到原点！！！
	
题解：https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
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