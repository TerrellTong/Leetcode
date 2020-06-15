/*
	算法思想：
		把str[0],作为res,然后以此为基础进行比较，如果遇到不相等的，则对res以此处为截断，构建新的res
	相当于进行了拆分，分治
	
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        //将第一个字符串作为初始字符串
        String result = strs[0];
        //从第二个字符串开始比较
        for(int i=1;i<strs.length;i++){
            int j = 0;
            for(;j<strs[i].length()&&j<result.length();j++){
                if(result.charAt(j) != strs[i].charAt(j))
                    break;
            }
            //进行字符串截断，截断后的res,是前两个字符串的公共前缀，这样就可以借由这个继续往下比较了
            result = result.substring(0,j);
            //如果截断后的字符串的空串，则直接返回
            if(result.equals(""))
                return result;
        }
        return result;
    }
}



