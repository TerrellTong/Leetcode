/*
	算法思想：
		怎么说呢 
			自己的思想是按照回溯的方法做的，用一个StringBuilder来存储当前遍历的字符串，而且res还是直接赋值的
	
			
		答案的思想，如果当前t_pos已经遍历到尾部了，则说明可以返回1，如果s的pos到达了尾部，则直接返回0，因为先判断的t，再判断的s
		对于记忆化搜索所存储的是，s的pos和t的pos。一直不知道到记忆化搜索存储什么？？？？
		对于这种累加类型的，一定要是res += dfs（xxx）  !!!!
		
		
题解：https://leetcode-cn.com/problems/distinct-subsequences/solution/hui-su-ji-yi-hua-po-su-dfschao-shi-by-hw_wt/
*/

class Solution {
    Map<String,Integer> memo = new HashMap();
    public int numDistinct(String s, String t) {
        return dfs(s,0,t,0);
    }

    public int dfs(String s,int pos,String t,int t_pos){
        if(t_pos == t.length()){
            return 1;
        }

        if(pos == s.length())
            return 0;

        String key = pos + "," + t_pos;
        if(memo.containsKey(key))
            return memo.get(key);

        int res = 0;
        for(int i=pos;i<s.length();i++){
            if(s.charAt(i) != t.charAt(t_pos))
                continue;
            res += dfs(s,i+1,t,t_pos+1);
        }
        
        memo.put(key,res);
        return res;
    }
}