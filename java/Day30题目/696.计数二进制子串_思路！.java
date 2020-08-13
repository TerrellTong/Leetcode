/*
	算法思想：
		学思路！！！
		我们可以将字符串s按照0和1的连续段分组，存在counts数组中，例如s =00111011，可以得到这样的counts数组：count={2,3,1,2}
		这里counts数组中两个相邻的数一定代表的是两种不同的字符。假设counts数组中两个相邻的数字为u或者v，它们对
		应着u个0和v个1，或者u个1和v个0。
		它们能组成的满足条件的子串数目为min{u,u}，即一对相邻的数字对答案的贡献。

	
https://leetcode-cn.com/problems/count-binary-substrings/solution/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
*/

class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList();
        int ptr = 0,n = s.length();
        while(ptr < n){
            char c = s.charAt(ptr);
            int count = 0;
            while(ptr < n&&s.charAt(ptr) == c){
                ptr++;
                count++;
            }
            counts.add(count);
        }
        int ans = 0;
        for(int i=1;i<counts.size();i++){
            ans += Math.min(counts.get(i),counts.get(i-1));
        }
        return ans;
    }
}