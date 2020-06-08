/*
	算法思想：
		记忆化搜索，从上往下进行遍历
	
*/
 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s,new HashSet(wordDict),0,new Boolean[s.length()]);
    }
    //记忆化搜索
    public boolean word_Break(String s,Set<String> wordDict,int start , Boolean[] memo){
        //如果start移动到了s的长度，因此返回true
        if(start == s.length())
            return true;
        if(memo[start] != null)
            return memo[start];
        //从start+1为end，然后判断Dict中是否有start,end子串的值
        for(int end = start+1;end <= s.length();end++){
            if(wordDict.contains(s.substring(start,end)) && word_Break(s,wordDict,end,memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}








