/*
	算法思想：
		记忆化搜索
	注意特殊情况！！ 自己写的！
	
	
*/

class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        //将list转成HashSet
        Set<String> wordSet = new HashSet(wordDict);
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return dfs(s,0,wordSet);
    }

    public boolean dfs(String s,int pos,Set<String> wordSet){
        if(pos == s.length())
            return true;
        if(memo[pos] != -1)
            return memo[pos] == 1 ? true : false;

        for(int i=pos;i<=s.length();i++){
            //必须dfs的下一层必须写在if中，因为存在“aaaaaaa”,"aaaa","aaa"这样的案例！！
            if(wordSet.contains(s.substring(pos,i)) && dfs(s,i,wordSet)){
                // memo[pos] = dfs(s,i,wordSet) == true ? 1 : 0;
                memo[pos] = 1;
                return true;
            }
        }
        memo[pos] = 0;
        return false;  
    }
}