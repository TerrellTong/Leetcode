/*
	算法思想：
		dfs+缓存（记忆化搜索）
	DFS思路:
		"leetcode"能否break，可以分解为："l"是否在单词表中，剩余子串能否break
		就是回溯，考察所有的可能，用指针 start 从左往右扫描 s 串
		如果指针的左侧的子串，是单词表中的单词，则对以指针为开头的剩余子串，递归考察
		比如下图遇到 "leet" 这个单词表里的单词，继续往下做
		如果指针的左侧的子串不是单词表里的，回溯，进入别的分支
	二刷！还是不会！

作者：hyj8
链接：https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
class Solution {
    HashSet<String> set;
    HashMap<String,Boolean> cache = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        //set用于存字典，将List<String>转成用Set存储
        set = new HashSet(wordDict);
        return dfs(s);
    }
    //深度优先遍历
    boolean dfs(String s){
        if(cache.containsKey(s))
            return cache.get(s);
        if(s.length() == 0)
            return true;
        for(int end = 1;end<=s.length();end++){
            //进行字符串截断
            String cur = s.substring(0,end);
            if(set.contains(cur)){
                //如果到end为止的子串，它在字典中，然后就开始从end开始的子串进行dfs遍历
                if(dfs(s.substring(end)))
                    return true;
            }
        }
        //如果返回,则直接记在缓存中，false
        cache.put(s,false);
        return false;
    }
}




