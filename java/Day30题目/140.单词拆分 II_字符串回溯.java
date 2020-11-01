/*
	算法思想：
		回溯，我知道是回溯，但是我的回溯过程比较复杂，也写不出来
		自己的思路：找到start，end,从而用for进行一一的比较，而且是那种没有带任何条件就进行dfs的
		这里的dfs，有条件的！！！，我是直接dfs(i+1)，思路错了
	
	字符串的回溯（做的少！），之前做的都是数字之类的回溯！！
	别人的思路，将wordDict放到set中，然后传入set，当pos到达s.length()，将队列中的元素放到res中（本题用的队列存储当前遍历元素！！）
	然后用循环进行遍历，直到找到了满足dict中的某个值就添加，然后再次进行dfs！！！
	
	字符串的回溯，都要满足条件了，进行添加和dfs!!!，与普通的数字不同！！！
*/

class Solution {
    List<String> res = new ArrayList();
    public List<String> wordBreak(String s, List<String> wordDict) {
        //将List的元素转到set中
        Set<String> set = new HashSet();
        for(String w:wordDict){
            set.add(w);
        }
        dfs(s,set,0,new LinkedList<String>());
        return res;
    }

    public void dfs(String s,Set<String> dict,int pos,LinkedList<String> queue){
        if(pos == s.length()){
            StringBuilder sb = new StringBuilder();
            for(String ss:queue){
                sb.append(ss);
                sb.append(" ");
            }
            //去掉最后一个空格
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        for(int j = pos+1;j<=s.length();j++){
            if(dict.contains(s.substring(pos,j))){
                queue.offerLast(s.substring(pos,j));
                dfs(s,dict,j,queue);
                queue.pollLast();
            }
        }   
    }
}


/**
题解（评论区Ruoji）：
	 List<String> res= new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        for(String w: wordDict){
            set.add(w);
        }
        //调用leetcode139 先判断能不能拆分
        if(!judge(s,set)){
            return res;
        }
        //开始回溯
        backTrace(s,set,0,new LinkedList<String>());
        return res;
    }

    
    private boolean judge(String s,Set<String> set){
        int n = s.length();
        boolean[] dp = new boolean[n+5];
        dp[0] = true;
        for(int i=1;i<=n ;++i){
            for(int j=0;j<i;++j){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    private void backTrace(String s, Set<String> dict, int pos,LinkedList<String> queue){
        if(pos ==s.length()){
            StringBuilder sb = new StringBuilder();
            for(String ss: queue){
                sb.append(ss);
                sb.append(" ");
            }
            //去掉最后一个空格
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        for(int j= pos+1; j<= s.length();++j){
            if(dict.contains(s.substring(pos,j))){
                queue.offerLast(s.substring(pos,j));
                backTrace(s,dict,j,queue);
                queue.pollLast();
            }
        }
    }
*/