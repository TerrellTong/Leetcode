/*
	算法思想：
		记忆化搜索也可以看成动态规划的一种形式
		记忆化搜索，是整数拆分的一种形式
		记忆化搜索时，我们只分析一层，然后下下层采用递归函数来解决！！

题解：

*/

class Solution {
    HashMap<Integer, Integer> memo = new HashMap();
    public int numDecodings(String s) {
        return Decoding(s,0);
    }

    public int Decoding(String s,int pos){
        if(pos == s.length())
            return 1;

        //当前位置的值为0，则返回0
        if(s.charAt(pos) == '0')
            return 0;
        int m = memo.getOrDefault(pos,-1);
        if(m != -1){
            return m;
        }

        //进行拆分
        //只有两种拆分，分成1个字符/分成两个字符

        //拆分成一个字符
        int ans1 = Decoding(s,pos+1);
        //拆分成两个字符的结果
        int ans2 = 0;
        if(pos + 1 < s.length()){
            int ten = (s.charAt(pos) - '0') * 10;
            int one = s.charAt(pos+1) - '0';
            if(ten + one <= 26)
                ans2 = Decoding(s,pos+2);
        }
        memo.put(pos,ans1 + ans2);
        return memo.get(pos);
    }
}