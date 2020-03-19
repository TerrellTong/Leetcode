 /*
	算法思想：
	回文串的特征：最多只有一个字符出现奇数次，其余都是偶数
	找好问题的关键点就可以进行代码的编写
	技巧：
		遇到有提示字符串仅包含小写（或者大写）英文字母的题，
		都可以试着考虑能不能构造长度为26的每个元素分别代表一个字母的数组，来简化计算。
		数组下标就是对应的字符减去相应的ASCII码后的值
 */
class Solution {
    public int longestPalindrome(String s) {
        //记录每个字符的个数，
        int[] count = new int[58];
        for(char c : s.toCharArray())
            //将字符与A的ASCII码进行相减，减少数组空间
            count[(int)c-'A']++;
        int res=0;
        for(int v : count){
            res += v/2*2;
            //如果V是奇数而且res还是偶数则进行res+1
            if(v%2==1&&res%2==0)
                res++;
        }
        return res;
    }
}



     




