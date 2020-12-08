/*
	算法思想：
		回溯剪枝，我知道核心，但是不知道如何进行剪枝！！
		我是按照最原始的想法做的，先找每一种出现的情况，然后进行判断！太愚蠢了！！！
		
		
*/

class Solution {
    List<Integer> res = new ArrayList();
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList();
        //将其转换成字节数组！
        dfs(S.toCharArray(),0,res);
        return res;
    }

    public boolean dfs(char[] digit,int pos,List<Integer> res){
        //只需要res的长度大于等于3即可
        if(pos == digit.length && res.size() >= 3){
            return true;
        }

        for(int i=pos;i<digit.length;i++){
            //两位数以上不能以0开头
            if(digit[pos] == '0' && i>pos)
                break;
            //截取字符串转化成数字
            long num = subDigit(digit,pos,i+1);

            int size = res.size();
            //如果截取到的数字大于res中的前两个和，说明截取大了，相当于剪枝
            if(size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if(size <= 1 || num == res.get(size-1) + res.get(size-2)){
                //把数字num添加到集合res中
                res.add((int) num);
                //如果找到了就直接返回
                if (dfs(digit, i + 1,res))
                    return true;
                //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
                res.remove(res.size() - 1);
            }
        }

        return false;
    }

    //相当于截取字符串S中的子串然后转换为十进制数字
    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
}