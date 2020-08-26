/*
	算法思想：
		回溯，此时的题目不需要在dfs()结束后出栈，因为它是字符串存的，而不是用list存的
		没想到进行用Map对应2-9！
		对于递归时的位置选取，有的时候是i,有的时候是idx+1,不理解这个位置！！
		具体问题，具体分析！
		
题目思路：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
*/


class Solution {
    //建立一个从2-9的映射表
    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //最终输出结果的list
	List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0)
            return new ArrayList();
        dfs(digits,"",0);
        return res;
    }

	//idx表示当前位置索引
    public void dfs(String digits,String cur,int idx){
        //如果当前索引是digits的长度，则添加到idx,并返回
        if(idx == digits.length()){
            res.add(cur);
            return;
        }

        //获取index位置的字符，假设输入的字符是"234"
		//第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
		//subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
		char c = digits.charAt(idx);
		//map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
		//比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
		int pos = c - '0';
		String map_string = letter_map[pos];
		//i表示2-9，对应有几种选择！
        for(int i=0;i<map_string.length();i++){
            dfs(digits,cur+map_string.charAt(i),idx+1);
        }
    }
}