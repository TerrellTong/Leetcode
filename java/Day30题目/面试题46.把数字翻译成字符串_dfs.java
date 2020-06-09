/*
	算法思想：
		dfs，深度优先遍历
		对于递归，有了更深次理解，递归栈的使用
	
*/
 
class Solution {
    public int translateNum(int num) {
        //将数字转成字符串
        String str = String.valueOf(num);
        return dfs(str,0);
    }
    //通过dfs进行遍历
    public int dfs(String str,int index){
        //如果当前下标大于等于字符串的长度-1，则说明当前位置是由上一次跳到此处的，则直接返回1
        if( index >= str.length()-1)
            return 1;
        //先求解每一次翻译一个字符的字符串
        int res = dfs(str,index+1);
        //以当前下标为开始，截取两位，并判断这位组成的数字是否在10-25之间
        //如果在这一次就可以直接翻译两个字符，然后从两个字符后面的位置进行翻译
        //substring,从index开始到endpos-1结束
        String temp = str.substring(index,index+2);
        if(temp.compareTo("10") >= 10 && temp.compareTo("25") <= 0)
            res += dfs(str,index+2);
        return res;
    }
}







