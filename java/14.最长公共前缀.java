//先拿一个字符串进行比较，然后再以此为基础进行公共前缀的寻找

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //如果传来一个空字符串，就直接返回""
        if(strs.length == 0) 
            return "";
        //将第一个字符串最为初始的字符串
        String result = strs[0];
        //从第二个字符串开始进行比较
        for(int i = 1;i<strs.length;i++){
            int j=0;
            //j既要小于自己本身的长度也需要小于待比较结果的字符串长度！
            for(;j<strs[i].length()&&j<result.length();j++){
                //取出字符串的第i个字符与默认的字符串进行比较
                if(result.charAt(j) != strs[i].charAt(j))
                    break;
            }
            //进行字符串截断
            result = result.substring(0,j); 
			//如果是空字符串就可以直接返回了
            if(result.equals(""))       
                return result;
        }
        return result;
    }
}